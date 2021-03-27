create table portfolio (portfolio_id int primary key);

create table asset (tid int primary key,assetid varchar(20),portfolioid int,type varchar(10),units int, foreign key(portfolioid) references portfolio(portfolio_id));