create table LOG(id INTEGER PRIMARY KEY ASC, client text, info text, total_amount int, total_price int);

create table MERCHANDISE (name text unique, amount int, price int);
create table REQUEST (name text,surname text,coordinates text, description text);
