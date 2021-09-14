CREATE TABLE user_table(
    id UUID NOT NULL primary key DEFAULT uuid_generate_v4(),
    name varchar(200) NOT NULL,
    lastname varchar(200)NOT NULL
)