#!/bin/bash

set -ex
wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
sudo apt install ./google-chrome-stable_current_amd64.deb

find /bin /opt /usr -name WebDriver

export PATH=$PATH:/opt/WebDriver/bin >> ~/.profile