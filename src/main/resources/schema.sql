CREATE TABLE PRICES (
  price_list INTEGER PRIMARY KEY,
  brand_id INTEGER NOT NULL,
  start_date TIMESTAMP NOT NULL,
  end_date TIMESTAMP NOT NULL,
  product_id INTEGER NOT NULL,
  priority INTEGER NOT NULL,
  price DECIMAL NOT NULL,
  currency VARCHAR(3) NOT NULL);