CREATE TYPE gender_type AS ENUM ('Masculino', 'Feminino', 'Não-Binário', 'Outro');

create table tb_patient (
    id UUID DEFAULT  gen_random_uuid() PRIMARY KEY ,
    name VARCHAR(100) NOT NULL,
    date_start_monitoring DATE,
    telephone VARCHAR(20),
    identifier INTEGER,
    birth_date DATE,
    gender gender_type,
    UBS VARCHAR(100),
    user_id UUID,
    FOREIGN KEY (user_id) REFERENCES tb_user(id) ON DELETE CASCADE
);