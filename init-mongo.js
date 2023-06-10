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

db.books.insertOne({
    title: "The Lord of the Rings: The Fellowship of the Ring",
    author: "J.R.R Tolkien",
    releaseDate: ISODate("1954-07-29T00:00:00Z"),
    isbnNumber: "1"
});

db.books.insertOne({
    title: "The Lord of the Rings: The Two Towers",
    author: "J.R.R Tolkien",
    releaseDate: ISODate("1954-11-11T00:00:00Z"),
    isbnNumber: "2"
});

db.books.insertOne({
    title: "The Lord of the Rings: The Return of the King",
    author: "J.R.R Tolkien",
    releaseDate: ISODate("1955-10-20T00:00:00Z"),
    isbnNumber: "3"
});

db.books.insertOne({
    title: "Diuna",
    author: "Frank Herbert",
    releaseDate: ISODate("1985-07-23T00:00:00Z"),
    isbnNumber: "4"
});