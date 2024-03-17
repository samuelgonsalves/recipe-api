INSERT INTO ingredient(name) VALUES ('Yogurt');
INSERT INTO ingredient(name) VALUES ('Chicken thighs');
INSERT INTO ingredient(name) VALUES ('Onions');
INSERT INTO ingredient(name) VALUES ('Garlic');
INSERT INTO ingredient(name) VALUES ('Tomato puree');

INSERT INTO recipe (title, description, image_url) VALUES ('Chicken tikka masala', 'Yummy and spicy', 'https://greatcurryrecipes.net/wp-content/uploads/2012/01/tik17-768x1024.jpg.webp');
INSERT INTO recipe (title, description, image_url) VALUES ('Chicken tandoori', 'Smoky, charred', 'https://www.onceuponachef.com/images/2015/01/tandoori-chicken-1.jpg');

INSERT INTO recipeingredient (recipe_id, ingredient_id) VALUES (1, 1);
INSERT INTO recipeingredient (recipe_id, ingredient_id) VALUES (1, 2);
INSERT INTO recipeingredient (recipe_id, ingredient_id) VALUES (1, 3);
INSERT INTO recipeingredient (recipe_id, ingredient_id) VALUES (1, 4);
INSERT INTO recipeingredient (recipe_id, ingredient_id) VALUES (1, 5);

INSERT INTO recipeingredient (recipe_id, ingredient_id) VALUES (2, 1);
INSERT INTO recipeingredient (recipe_id, ingredient_id) VALUES (2, 2);
INSERT INTO recipeingredient (recipe_id, ingredient_id) VALUES (2, 4);