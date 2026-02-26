CREATE TABLE tb_user(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY ,
    name VARCHAR(100) NOT NULL ,
    login VARCHAR(50) NOT NULL ,
    password VARCHAR(100) NOT NULL ,
    email VARCHAR(50) NOT NULL
)