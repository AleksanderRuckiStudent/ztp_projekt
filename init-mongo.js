db.createUser(
    {
        user: "root",
        pwd: "secret",
        roles: [
            {
                role: "readWrite",
                db: "ztp_database"
            }
        ]
    }
);

// BOOKS
db.books.insertOne({
    _id: ObjectId('64862f9b1a6e1bf6b20463bd'),
    isbnNumber: "9780618260294",
    title: "The Lord of the Rings: The Fellowship of the Ring",
    author: "J.R.R Tolkien",
    releaseDate: ISODate("1954-07-29T00:00:00Z")
});

db.books.insertOne({
    isbnNumber: "9780618260295",
    title: "The Lord of the Rings: The Two Towers",
    author: "J.R.R Tolkien",
    releaseDate: ISODate("1954-11-11T00:00:00Z")
});

db.books.insertOne({
    isbnNumber: "9780618260296",
    title: "The Lord of the Rings: The Return of the King",
    author: "J.R.R Tolkien",
    releaseDate: ISODate("1955-10-20T00:00:00Z")
});

db.books.insertOne({
    isbnNumber: "9780618260297",
    title: "Diuna",
    author: "Frank Herbert",
    releaseDate: ISODate("1985-07-23T00:00:00Z")
});
