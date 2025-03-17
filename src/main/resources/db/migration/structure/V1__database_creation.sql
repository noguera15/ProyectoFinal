CREATE TABLE users (
    id bigint primary key generated always as identity,
    name text not null,
    lastname text not null,
    email text not null
);