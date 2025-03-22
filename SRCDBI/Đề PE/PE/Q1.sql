
-- Tạo bảng Hotel
CREATE TABLE Hotel (
    HotelCode varchar(10) NOT NULL,
    name nvarchar(255),
    address nvarchar(255),
    CONSTRAINT PK_Hotel PRIMARY KEY (HotelCode)
);


-- Tạo bảng Customer
CREATE TABLE Customer (
    customerid int NOT NULL,
    name nvarchar(50),
    address nvarchar(200),
    CONSTRAINT PK_Customer PRIMARY KEY (customerid)
);


-- Tạo bảng Room
CREATE TABLE Room (
    roomNumber int NOT NULL,
    bedNo int,
    HotelCode varchar(10) NOT NULL,
    CONSTRAINT PK_Room PRIMARY KEY (roomNumber, HotelCode),
    CONSTRAINT FK_Room_Hotel FOREIGN KEY (HotelCode) REFERENCES Hotel(HotelCode)
);


-- Tạo bảng Book
CREATE TABLE Book (
    customerid int NOT NULL,
    roomNumber int NOT NULL,
    HotelCode varchar(10) NOT NULL,
    orderid int NOT NULL,
    CONSTRAINT PK_Book PRIMARY KEY (orderid),
    CONSTRAINT FK_Book_Customer FOREIGN KEY (customerid) REFERENCES Customer(customerid),
    CONSTRAINT FK_Book_Room FOREIGN KEY (roomNumber, HotelCode) REFERENCES Room(roomNumber, HotelCode)
);