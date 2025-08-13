# 제어문
# 1. if
weather="비"
if weather == "비" :
  print("우산써요")

weather2="햇"
if weather2 == "해" :
  print("더워요")
elif weather2=="비":
  print("우산써요")
else :
  print("구름이 있어요")
  

#2. for
# 한개씩 (영역)어디에서 꺼내오세요
for i in range(1,11) : #1~10까지 11전까지
  print (i, end=" ")

print() 
#2-1. 1 2 3
for i in range(1,4) : #1~3까지 4전까지
  print (i,end=" ")

print()
#2-2. 안녕아리는 문자열 안 녕
for i in "안녕" :
  print(i,end="*")
  
print()
#3. while
i = 1 #초기
while i<4 : #조건
  print(i,end=" ")
  i=i+1 #증감
  
print()
#3-1. 3 2 1
i = 3 #초기
while i>0 : #조건
  print(i,end=" ")
  i=i-1 #증감
  
print()
#4. break, continue
for i in range(4) : # 0 1 (2 3)
  if i==2:
    break
  print(i,end=" ")
  
print()
for i in range(4) : # 0 1 (2) 3
  if i==2:
    continue #건너뛰기
  print(i,end=" ")
  
print()
#5. 사용자로부터 문자를 계속 입력받다가 "q"를 입력하면 반복을 종료하세요.

while True :
  answer=input("종료하려면 q입력 : ")
  if answer =="q" :
    print("종료합니다.")
    break