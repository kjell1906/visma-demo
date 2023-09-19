# Demo App Visma Technical interview

## Why I choose to use Spring Boot instead of ordinary Java?

Instead of using default Java, and all the libraries to enable both database connectivity
and add all libraries to enable rest through servlets, I found it easier and faster
to use a framework with contains all the needed features and is battle proved and is my first choice
when building rest projects in Java. I hope this is Ok since the task did not explicitly say that I had to write project in 
plain Java.

## Startup

This project uses Spring Boot to run the backend and expose data through rest endpoints.
Database is a Postgres DB set up in Docker and is run within a docker container.

Command to start database:

docker-compose -f docker-composer.yml up

### SQL Start data

> INSERT INTO category (id, name) VALUES
(nextval('category_id_sequence'), 'Furniture'),
(nextval('category_id_sequence'), 'Textile'),
(nextval('category_id_sequence'), 'Meals');

> INSERT INTO item (category_id, id, price, weight, color, description, flavor, item_number) VALUES
(1, nextval('item_id_sequence'), 1000, 20, '', 'wardrobe', '', 1000),
(2, nextval('item_id_sequence'), 600, 8, 'white', 'rug', '', 2000),
(2, nextval('item_id_sequence'), 500, 10, 'brown', 'carpet', '', 3000),
(3, nextval('item_id_sequence'), 20, NULL, NULL, 'chili-flavored hotdog', 'chili-flavored', NULL),
(3, nextval('item_id_sequence'), 25, NULL, NULL, 'vegetarian hotdog', 'vegetarian', NULL);

> INSERT INTO member (id, name) VALUES
(nextval('member_id_sequence'), 'Per'),
(nextval('member_id_sequence'), 'Ola');

> INSERT INTO discount (id, item_id, member_id, percentage, name) VALUES
(nextval('discount_id_sequence'),3, 1, 5, 'hot dogs'),
(nextval('discount_id_sequence'),1, 1, 10, 'furniture');


### Rest endpoint addresses

```
POST http://localhost:8080/create_order Body Content: [
{
        "flavor": "vegetarian",
        "itemNumber": "",
        "memberId": 1
    },
    {
        "flavor": "",
        "itemNumber": "1000",
        "memberId": 1
    },
    {
        "flavor": "",
        "itemNumber": "2000",
        "memberId": 1
    }]

```
```
GET http://localhost:8080/get_order?id=1 
Response Data: 
[
{
"itemNumber": null,
"product": "vegetarian hotdog",
"discount": "hot dogs",
"percentage": 5
},
{
"itemNumber": "1000",
"product": "wardrobe",
"discount": "furniture",
"percentage": 10
},
{
"itemNumber": "2000",
"product": "rug",
"discount": "",
"percentage": null
}
]
```

