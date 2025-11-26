#!/bin/bash
# GitHub推送脚本
# 使用方法: bash push-to-github.sh YOUR_USERNAME REPO_NAME

if [ $# -lt 2 ]; then
    echo "使用方法: bash push-to-github.sh YOUR_USERNAME REPO_NAME"
    echo "示例: bash push-to-github.sh myusername spring-boot-project"
    exit 1
fi

USERNAME=$1
REPO_NAME=$2

echo "正在添加GitHub远程仓库..."
git remote add origin https://github.com/${USERNAME}/${REPO_NAME}.git

echo "正在推送代码到GitHub..."
git branch -M main
git push -u origin main

echo "完成！代码已推送到GitHub: https://github.com/${USERNAME}/${REPO_NAME}"

