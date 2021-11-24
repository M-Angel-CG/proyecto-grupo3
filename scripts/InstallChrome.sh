#!/bin/bash

set -ex
wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
sudo apt install ./google-chrome-stable_current_amd64.deb

export PATH=$PATH:/opt/WebDriver/bin >> ~/.profile

wget https://chromedriver.storage.googleapis.com/96.0.4664.45/chromedriver_linux64.zip

sudo apt-get install unzip
unzip chromedriver_linux64.zip -d drivers