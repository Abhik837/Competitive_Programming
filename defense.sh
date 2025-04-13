Giga Script:
#!/bin/bash

echo "[+] Starting Mega Defense Setup..."

### 1. Lock /root and /tmp
chmod 700 /root
chmod 1777 /tmp

# Create a secure flag directory
mkdir -p /tmp/secure_flags
chown root:root /tmp/secure_flags
chmod 700 /tmp/secure_flags

### 2. Strip SUID and SGID from all binaries
find / -perm -4000 -type f -not -path "/proc/*" -exec chmod u-s {} \; 2>/dev/null
find / -perm -2000 -type f -not -path "/proc/*" -exec chmod g-s {} \; 2>/dev/null

### 3. Disable dangerous binaries
chmod -x /bin/nc /usr/bin/nc /usr/bin/curl /usr/bin/wget /usr/bin/perl /usr/bin/python /usr/bin/python3 /usr/bin/php /usr/bin/sudo 2>/dev/null

### 4. Harden cron
chmod -R 700 /etc/cron.d /etc/cron.daily /etc/cron.hourly /etc/cron.weekly /etc/cron.monthly
chmod 700 /var/spool/cron
chown -R root:root /etc/cron.* /var/spool/cron
crontab -r 2>/dev/null
rm -rf /etc/crontab /etc/cron.d/* /var/spool/cron/* 2>/dev/null

### 5. Flag hardener script
cat << 'EOF' > /root/harden_flags.sh
#!/bin/bash
SAFE_DIR="/tmp/secure_flags"

mkdir -p "$SAFE_DIR"
chmod 700 "$SAFE_DIR"
chown root:root "$SAFE_DIR"

# Move any new flags from /root and /tmp into the secure directory
for src_dir in /root /tmp; do
  for f in "$src_dir"/flag.txt; do
    [ -f "$f" ] || continue
    fname=$(basename "$f")
    new_path="$SAFE_DIR/$fname"

    # If not already secured, move and lock
    if [ "$f" != "$new_path" ]; then
      mv "$f" "$new_path"
    fi
  done
done

# Apply strict permissions
for f in "$SAFE_DIR"/flag.txt; do
  [ -f "$f" ] || continue
  chown root:root "$f"
  chmod 400 "$f"
done
EOF

# Re-harden flags every minute
( crontab -l 2>/dev/null; echo "* * * * * /root/harden_flags.sh" ) | crontab -

### 6. Firewall lockdown (only allow SSH, DNS, VPN)
iptables -F
iptables -P INPUT DROP
iptables -P FORWARD DROP
iptables -P OUTPUT DROP
iptables -A INPUT -i lo -j ACCEPT
iptables -A INPUT -p tcp --dport 22 -j ACCEPT
iptables -A INPUT -m conntrack --ctstate ESTABLISHED,RELATED -j ACCEPT
iptables -A OUTPUT -o lo -j ACCEPT
iptables -A OUTPUT -p udp --dport 53 -j ACCEPT       # DNS
iptables -A OUTPUT -p udp --dport 1194 -j ACCEPT     # VPN
iptables -A OUTPUT -p tcp --dport 1194 -j ACCEPT     # VPN
iptables -A OUTPUT -m conntrack --ctstate ESTABLISHED,RELATED -j ACCEPT

### 7. Watch for reverse shell behavior
cat << 'EOF' > /root/watch_shells.sh
#!/bin/bash
while true; do
  ps aux | grep -E "bash|nc|perl|python|php|sh|curl|wget" | grep -v grep >> /root/rev_shells.log
  sleep 5
done
EOF
chmod +x /root/watch_shells.sh
nohup /root/watch_shells.sh &

echo "[✓] Mega Defense Complete. Your flags are safe and the attackers are locked out."
