CREATE TABLE assignment0820.customers (
  customer_id SERIAL PRIMARY KEY,
  name        VARCHAR(50) NOT NULL,
  email       VARCHAR(100) UNIQUE NOT NULL,
  city        VARCHAR(50),
  joined_at   DATE NOT NULL
);

CREATE TABLE assignment0820.products (
  product_id  SERIAL PRIMARY KEY,
  name        VARCHAR(50) NOT NULL,
  category    VARCHAR(50) NOT NULL,
  price       NUMERIC(10,2) NOT NULL CHECK (price >= 0)
);

CREATE TABLE assignment0820.orders (
  order_id    SERIAL PRIMARY KEY,
  customer_id INT NOT NULL REFERENCES customers(customer_id),
  ordered_at  TIMESTAMP NOT NULL,
  status      VARCHAR(20) NOT NULL CHECK (status IN ('PAID','CANCELLED','SHIPPED'))
);

CREATE TABLE assignment0820.order_items (
  order_item_id SERIAL PRIMARY KEY,
  order_id   INT NOT NULL REFERENCES orders(order_id) ON DELETE CASCADE,
  product_id INT NOT NULL REFERENCES products(product_id),
  qty        INT NOT NULL CHECK (qty > 0),
  unit_price NUMERIC(10,2) NOT NULL CHECK (unit_price >= 0)
);
USE assignment0820;
-- 샘플 데이터
INSERT INTO assignment0820.customers (name,email,city,joined_at) VALUES
('Kim','kim@example.com','Seoul','2025-07-01'),
('Lee','lee@example.com','Busan','2025-07-10'),
('Park','park@example.com','Seoul','2025-08-01'),
('Choi','choi@example.com','Incheon','2025-08-05');

INSERT INTO products (name,category,price) VALUES
('Keyboard','Electronics', 45000),
('Mouse','Electronics', 25000),
('Monitor 27"','Electronics', 290000),
('Mug','Lifestyle', 9000),
('Notebook','Stationery', 3000),
('Pen','Stationery', 1000);

INSERT INTO orders (customer_id, ordered_at, status) VALUES
(1,'2025-08-10 10:00','PAID'),
(1,'2025-08-11 09:30','CANCELLED'),
(2,'2025-08-12 14:00','SHIPPED'),
(3,'2025-08-12 18:20','PAID');

INSERT INTO order_items (order_id, product_id, qty, unit_price) VALUES
(1, 1, 1, 45000),    -- Keyboard
(1, 2, 2, 24000),    -- Mouse (할인 가정)
(1, 4, 1, 9000),     -- Mug
(2, 3, 1, 290000),   -- Monitor (주문 취소건)
(3, 2, 1, 25000),    -- Mouse
(3, 6, 5, 1000),     -- Pen
(4, 1, 1, 45000),    -- Keyboard
(4, 5, 3, 2800);     -- Notebook (할인 가정)




USE assignment0820;
-- 1) SELECT / WHERE / ORDER BY / LIMIT
SELECT * FROM customers;

-- products에서 category가 Electronics 또는 Lifestyle인 상품을 이름 내림차순으로 조회하세요.
Select product_id, name, category from products 
where category IN ('Electronics', 'Lifestyle') order by name DESC;
-- category = 'Electronics' OR category = 'Lifestyle'로 하면 or 사용하면 됨 

-- products에서 가장 비싼 상품 3개의 name, price를 조회하세요.
--  Select MAX(price) AS product_id, name, price from products; 이게 아니라 
Select product_id, name, price from products 
order by price DESC
limit 3;

select  name, customer_id,email from assignment0820.customers 
where email Like '%@example.com' Order By name ASC;


-- customers에서 city가 NULL이 아닌 고객의 도시 목록(중복 제거)을 조회하세요.
select Distinct city from customers where city is not Null;



-- 2) 집계 / GROUP BY / HAVING
SELECT * FROM assignment0820.orders;
SELECT * FROM assignment0820.order_items;
SELECT * FROM assignment0820.products;
-- orders에서 상태별 주문 수(status, cnt)를 조회하세요.
select status, count(*) AS cnt From orders GROUP BY status;
-- order items에서 주문별 라인수(한 주문에 들어있는 항목 수)를 조회하세요.
select order_id, count(*) as total_qty from order_items group by order_id;
-- order items에서 주문별 총수량(sum(qty))이 5 이상인 주문만 조회하세요.
select order_id, sum(qty) AS total_qty from order_items group by order_id Having sum(qty)>= 5;
-- products에서 카테고리별 평균 가격을 반올림하여 조회하세요.
select category, round(avg(price), 0) as cg_avg from products group by category;


-- 3. DML (INSERT/UPDATE/DELETE)
SELECT * FROM assignment0820.orders;
SELECT * FROM assignment0820.order_items;
SELECT * FROM assignment0820.products;
SELECT * FROM assignment0820.customers;
-- products에 새 상품을 추가하세요.
INSERT INTO products (name,category,price) VALUES ('bottle', 'Lifestyle', 10);
-- customers에서 Busan 거주 고객의 city를 Busan-si로 수정하세요.
SET SQL_SAFE_UPDATES = 0;
UPDATE customers SET city = 'Busan-Si' where city = 'Busan';
-- orders에서 1년 이전의 CANCELLED 주문을 삭제하세요.   대소문자 주의 
Delete From orders where status = 'CANCELLED' AND ordered_at < date_sub(now(), interval 1 year);
-- order items에서 qty=0인 행들을 삭제하세요.
Delete from order_items where qty = 0;

-- 4. 계산식 / 표현식 / CASE

-- products에서 price에 10% 할인한 할인가(sale price)를 함께 조회하세요.
Select price, price*0.9 AS sale_price from products; 
-- orders에서 상태를 한글로 치환(PAID→결제완료, SHIPPED→배송중, CANCELLED→취소)하여 조회하세요.
-- when 다음 거 쓸때는 쉼표 안쓰고 else 써줘야 된다. 특정 조건문 흐름제어 문 
select status, case when status = 'PAID' then '결제완료' when status = 'SHIPPED' then'배송중' when status = 'CANCELLED' then '취소' else '기타' end AS status_kor from orders;
-- order_items에서 qty*unit price를 line amount로 계산하여 조회하세요.
select qty, unit_price, qty*unit_price as line_amount from order_items;

