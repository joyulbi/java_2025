import json, os, csv, platform
import pandas as pd     # 데이터분석
import matplotlib.pyplot as plt   # 그래프
from selenium import webdriver    # 크롤링 - 웹페이지에 정보가져오기
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from bs4 import BeautifulSoup   # html 원하는 정보를 추출

# pip install requests    
# pip install selenium beautifulsoup4 matplotlib pandas
# python -m  pip install requests 

# 1. 기본계좌클래스
# 상태 : id, pw, balance / 행위 : deposit , withraw , to_dict
class  Account:
  def __init__(self , id, pw, balance=0):
    self.id = id
    self.pw = pw
    self.balance=balance
  
  def deposit(self, amount) : 
    self.balance  += amount
    print(f"입금완료! 현재잔액 : {self.balance}")  
    
  def withdraw(self, amount) : 
    if self.balance >= amount : 
      self.balance  -= amount
      print(f"출금완료! 현재잔액 : {self.balance}")  
    else : 
      print(" 잔액이 부족합니다.")  
      
  def  to_dict(self):
    return {"id":self.id , "pw" : self.pw  , "balance" : self.balance}
  
# 2. 프리미엄 계좌 (출금시 수수료 100)
class PremiumAccount(Account) :
  def withdraw(self, amount) : 
    fee = 100
    total = amount + fee
    if self.balance >= total : 
      self.balance  -= total
      print(f"프리미엄 출금완료! (수수료 100 포함) 현재잔액 : {self.balance}")  
    else : 
      print("잔액이 부족합니다.(수수료 포함)")  

# my  = PremiumAccount("first" , "1111" , 1000)
# my.deposit(1000)
# my.withdraw(2500)
# my.withdraw(1200)

# 3. 은행시스템클래스
class BankSystem:
  # 파일계좌만들기
  def __init__(self):
    self.accounts = self.load_accounts()
  
  # 저장하기
  def  load_accounts(self) : 
    if os.path.exists("accouts.json") : 
      with open("accounts.json" , "r" ,encoding="utf-8") as f:
        data=json.load(f)
        return [PremiumAccount(acc["id"],acc["pw"],acc["balance"]) for acc in data ]
    return []  
  
  def  save_accounts(self) : 
      with open("accouts.json" , "w" ,encoding="utf-8") as f:
        json.dump([ acc.to_dict()  for acc in self.accounts ] , f ,   ensure_ascii=False , indent=2)
  
  # 계좌찾기
  def  find_account(self) : 
    id = input("아이디   : ")
    pw = input("비밀번호 : ")
    for acc in self.accounts : 
      if acc.id == id  and  acc.pw == pw : 
        return acc
    return None  
  
  # 1.계좌 추가
  def add_account(self) : 
    print("계좌추가")
    id = input("아이디   : ")
    pw = input("비밀번호 : ")
    balance = float(input("초기잔액 : "))
    acc = PremiumAccount(id,pw, balance)
    self.accounts.append(acc)
    self.save_accounts()
    print("프리미엄 계좌가 등록되었습니다.")
    
  # 2.계좌조회
  def view_account(self) :
    print("계좌조회")
    acc = self.find_account()
    if acc : 
      print(f"계좌정보 - ID:{acc.id}, 잔약 : {acc.balance}")
    else : 
      print(f"계좌를 찾을 수 없습니다.")
      
  # 3. 입금
  def deposit(self) :
    print("입금")
    acc = self.find_account()
    if acc :
        amount = float(input("입금 금액: "))
        acc.deposit(amount)
        self.save_accounts()
    else :
        print(f"계좌를 찾을 수 없습니다.")
  
  # 4. 출금
  def withdraw(self) :
    print("출금")
    acc = self.find_account()
    if acc :
        amount = float(input("출금 금액: "))
        acc.withdraw(amount)
        self.save_accounts()
    else :
        print(f"계좌를 찾을 수 없습니다.")

  
  # 5.계좌삭제
  def delete_account(self):
    print("계좌삭제")
    acc = self.find_account()
    if acc:
      self.accounts.remove(acc)
      self.save_accounts()
      print("계좌가 삭제되었습니다.")
    else : 
      print(f"계좌를 찾을 수 없습니다.")
      
  # 6.금리 추천보기
  def show_rates(self) :
    pass
  
  # 7.금리 시각화차트
  # 8.은행별 평균금리 시각화차트
  
  def run(self):
    while True : 
      print("\n\n\n======BANK======" ,"1. 계좌 추가","2. 계좌 조회","3. 입금","4. 출금","5. 계좌 삭제",
            "6. 금리 추천보기","7. 금리 시각화차트","8. 은행별 평균금리 시각화차트","9. 종료", sep="\n")
      choice=input("입력>>")
      if choice == "1" : 
        self.add_account()
      elif choice == "2" : 
        print("계좌 조회")
      elif choice == "3" : 
        print("입금")
      elif choice == "4" : 
        print("출금")
      elif choice == "5" : 
        print("계좌 삭제")
      elif choice == "6" : 
        print("금리 추천보기")
      elif choice == "7" : 
        print("금리 시각화차트")
      elif choice == "8" : 
        print("은행별 평균금리 시각화차트")
      elif choice == "9" : 
        print("종료합니다.")
        break

# 4.프로그램실행
if __name__ == "__main__" : 
  app  = BankSystem()
  app.run()