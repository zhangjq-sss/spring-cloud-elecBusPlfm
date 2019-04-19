source /etc/profile

ps aux | grep poc |  awk '{print $2}' | xargs kill -9

