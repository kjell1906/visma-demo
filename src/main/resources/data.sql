INSERT INTO category (id, name) VALUES
(nextval('category_id_sequence'), 'Furniture'),
(nextval('category_id_sequence'), 'Textile'),
(nextval('category_id_sequence'), 'Meals');

INSERT INTO item (category_id, id, price, weight, color, description, flavor, item_number) VALUES
(1, nextval('category_id_sequence'), 1000, 20, '', 'wardrobe', '', 1000),
(2, nextval('category_id_sequence'), 600, 8, 'white', 'rug', '', 2000),
(2, nextval('category_id_sequence'), 500, 10, 'brown', 'carpet', '', 3000),
(3, nextval('category_id_sequence'), 20, NULL, NULL, 'chili-flavored hotdog', 'chili-flavored', NULL),
(3, nextval('category_id_sequence'), 25, NULL, NULL, 'vegetarian hotdog', 'vegetarian', NULL);

INSERT INTO member (id, name) VALUES
(nextval('member_id_sequence'), 'Per'),
(nextval('member_id_sequence'), 'Ola');

INSERT INTO discount (id, member_id, percentage, name) VALUES
(nextval('discount_id_sequence'), 1, 5, 'hot dogs'),
(nextval('discount_id_sequence'), 1, 10, 'furniture');

INSERT INTO order_line (id, line_amount, quantity, order_id, discount_id, item_id) VALUES
(nextval('order_line_id_sequence'), 29, 1, 1, 1, 1);