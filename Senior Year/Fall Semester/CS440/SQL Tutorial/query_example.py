import mysql.connector

config = {
  'user': 'csci440',
  'password': 'csci440',
  'host': '127.0.0.1',
  'database': 'COMPANY',
  'raise_on_warnings': True,
}

cnx = mysql.connector.connect(**config)

cursor = cnx.cursor()

query = ("SELECT * "
         "FROM EMPLOYEE "
         "WHERE employee.Super_ssn IS NOT NULL;")

cursor.execute(query)

for (Fname, Minit, Lname, Ssn, Bdate, Address, Sex, Salary, Super_ssn, Dno) in cursor:
  print("{}, {}".format(Fname, Lname))

cursor.close()

cnx.close()
