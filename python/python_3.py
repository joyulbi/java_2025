############################################
# 1. List : 순서대로 담아요 (기차) ["곰인형", "자동차", "로봇"]
# 2. Tuple : 바뀌지 않는 생일 달력 ("1월","2월","3월")
# 3. 딕셔너리 : 이름표가 붙은 물건 {"사과":"빨강","바나나:"노랑}
# 4. 셋 : 같은건 하나만! 중복 X {"딸기,"딸기","포도"} → {"딸기","포도"}

# List - 장난감 바구니 [{},{},{}]
toys = ["곰인형","자동차","로봇"] #append, remove
toys.append("퍼즐")
print(toys)
toys.remove("자동차")
print(toys)
print(toys[1])

# Tuple - 바뀌지 않는 생일달력
months = ("1월","2월","3월") # 0 1 2
# months[1]="4월"  #'tuple' object does not support item assignment
print(months[1])

# 딕셔너리 - 이름표가 붙은 물건
colors = {"사과":"빨강","바나나":"노랑"} 
print(colors)
colors["바나나"]="초록"
print(colors["바나나"])

#셋 - 중복안됨
fruits={"딸기","딸기","포도"}
print(fruits)