CREATE TABLE IF NOT EXISTS basic_user_details (
  	user_id VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    mobile_number CHAR(10) NOT NULL,
    registered_date DATE,
    PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS payment_options (
    payment_mode VARCHAR(50) NOT NULL,
    available_balance INT,
    is_wallet TINYINT,
    description TEXT,
    cashback_amount INT,
    is_user_linked TINYINT,
    PRIMARY KEY (payment_mode)
);

CREATE TABLE IF NOT EXISTS machine_details (
    machine_id VARCHAR(255) NOT NULL,
    description TEXT,
    recommended_machine_clean_days INT,
    machine_rent_paid INT,
    PRIMARY KEY (machine_id)
);


CREATE TABLE IF NOT EXISTS machine_product_details (
	machine_id VARCHAR(255) NOT NULL,
    product_id VARCHAR(255) NOT NULL,
    product_name VARCHAR(255) NOT NULL,
    amount_unit VARCHAR(10),
    amounts_required INT,
    description TEXT,
    cost INT,
    offer_percentage INT,
    PRIMARY KEY (machine_id,product_id,amount_unit,amounts_required)
);


CREATE TABLE IF NOT EXISTS machine_orders_and_txns (
	txn_id INT NOT NULL AUTO_INCREMENT
    machine_id VARCHAR(255) NOT NULL,
    product_id VARCHAR(255) NOT NULL,
    amount_unit VARCHAR(10) NOT NULL,
    amounts_required INT,
    order_time DATETIME,
    payment_status VARCHAR(20),
    PRIMARY KEY (txn_id)
);

CREATE TABLE IF NOT EXISTS user_order_details (
    uuid VARCHAR(255) NOT NULL,
    machine_id VARCHAR(255) NOT NULL,
    product_id VARCHAR(255) NOT NULL,
    amount_unit VARCHAR(10) NOT NULL,
    amounts_required INT,
 	order_time DATETIME,
    payment_status VARCHAR(20),
    PRIMARY KEY (uuid,machine_id,product_id,amount_unit,amounts_required)
);


