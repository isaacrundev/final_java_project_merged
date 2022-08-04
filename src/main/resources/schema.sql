-- CREATE SEQUENCE IF NOT EXISTS hibernate_sequence;
-- CREATE SEQUENCE IF NOT EXISTS employee_seq;

-- CREATE TABLE IF NOT EXISTS employee(
--     employee_id BIGINT NOT NULL DEFAULT nextval('employee_seq') PRIMARY KEY,
--     fullName VARCHAR(100) NOT NULL,
--     birthday VARCHAR(100) NOT NULL
-- );


-- CREATE SEQUENCE IF NOT EXISTS clients_seq;
-- CREATE TABLE IF NOT EXISTS clients(
--    client_id BIGINT NOT NULL DEFAULT nextval('clients_seq') PRIMARY KEY,
--    company_name VARCHAR(100) NOT NULL,
--    contact_person VARCHAR(100) NOT NULL,
--    phone_number VARCHAR(100) NOT NULL,
--    email_address VARCHAR(100) NOT NULL,
--    department VARCHAR(100) NOT NULL,
--    position VARCHAR(100) NOT NULL,
--    notes VARCHAR(256) NULL
-- );


-- -- CREATE SEQUENCE IF NOT EXISTS products_seq;
-- -- CREATE TABLE IF NOT EXISTS products(
-- --     productsId BIGINT NOT NULL DEFAULT nextval('products_seq') PRIMARY KEY,
-- --     productName VARCHAR(100) NOT NULL,
-- --     price VARCHAR(100) NOT NULL
-- -- );