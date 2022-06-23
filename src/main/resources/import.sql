

insert into author(author_id, author_name, contact) values (1, 'Author1','0788445566');
insert into author(author_id, author_name, contact) values (2, 'Author2','0783336434');
insert into author(author_id, author_name, contact) values (3, 'Author3','0721111577');

insert into publisher(publisher_id, publisher_name) values (1, 'Publisher1');
insert into publisher(publisher_id, publisher_name) values (2, 'Publisher2');

insert into book_details(book_details_id, description, no_of_pages, price) values(1, 'Book description 1',200, 30.50);
insert into book_details(book_details_id, description, no_of_pages, price) values(2, 'Book description 2',450, 99.99);
insert into book_details(book_details_id, description, no_of_pages, price) values(3, 'Book description 3',180, 50.00);
insert into book_details(book_details_id, description, no_of_pages, price) values(4, 'Book description 4',290, 78.50);

insert into book(book_id, book_name, book_details_id, author_id, publisher_id) values(1, 'Book 1', 1, 1, 1);
insert into book(book_id, book_name, book_details_id, author_id, publisher_id) values(2, 'Book 2', 2, 2, 1);
insert into book(book_id, book_name, book_details_id, author_id, publisher_id) values(3, 'Book 3', 3, 3, 2);
insert into book(book_id, book_name, book_details_id, author_id, publisher_id) values(4, 'Book 4', 4, 2, 2);

insert into library(library_id, location) values(1, 'Iasi, str. Muresului');
insert into library(library_id, location) values(2, 'Cluj, str. Dambovitei');


insert into library_book(library_id, book_id) values (1, 1);
insert into library_book(library_id, book_id) values (1, 2);
insert into library_book(library_id, book_id) values (1, 3);
insert into library_book(library_id, book_id) values (1, 4);

insert into librarian(librarian_id, librarian_name, email, library_id) values(1, 'Librarian1', 'lib1@gmail.com', 1);
insert into librarian(librarian_id, librarian_name, email, library_id) values(2, 'Librarian2', 'lib2@yahoo.com', 1);

