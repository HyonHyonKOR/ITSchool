from cx_Oracle import connect
# DB 연결
con = connect("rnjsgurah2/1234@localhost:1521/xe")

# sql문 작성
sql = "select c_name,c_price,c_bean from oct20_coffee order by c_price"

# DB관련 총괄 객체 / sql 수행 결과(select문 결과)
cur = con.cursor()

# sql문 수행
cur.execute(sql) # 수행하면 select의 결과가 cur에 tuple로 들어가게 됨

# for c in cur:
    # print(c,type(c))

for n,p,b in cur:
    print(n,p,b)
    print("------------")

con.close()