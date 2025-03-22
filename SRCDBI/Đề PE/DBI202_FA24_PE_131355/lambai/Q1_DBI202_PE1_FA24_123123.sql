CREATE DATABASE LibraryDB;
GO

USE LibraryDB;
GO

-- Tạo bảng Borrowers
CREATE TABLE Borrowers (
    BorrowerID INT PRIMARY KEY,    -- Khóa chính, định danh duy nhất cho mỗi người mượn
    FirstName NVARCHAR(50) NOT NULL, -- Tên người mượn
    LastName NVARCHAR(50) NOT NULL,  -- Họ người mượn
    Email NVARCHAR(100) UNIQUE,    -- Email (mỗi người chỉ có một email duy nhất)
    MembershipDate DATE            -- Ngày đăng ký làm thành viên
);
GO

-- Tạo bảng Books
CREATE TABLE Books (
    BookID INT PRIMARY KEY,      -- Khóa chính, định danh duy nhất cho mỗi sách
    Title NVARCHAR(255) NOT NULL, -- Tiêu đề sách
    Genre NVARCHAR(100),         -- Thể loại sách
    PublicationYear INT,         -- Năm xuất bản
    AvailableCopies INT CHECK (AvailableCopies >= 0) -- Số bản sách còn có thể mượn
);
GO

-- Tạo bảng LoanSlip
CREATE TABLE LoanSlip (
    LoanID INT PRIMARY KEY,        -- Khóa chính, định danh duy nhất cho phiếu mượn
    LoanDate DATE NOT NULL,        -- Ngày mượn sách
    DueDate DATE NOT NULL,         -- Ngày đến hạn trả sách
    ReturnDate DATE NULL,          -- Ngày thực tế trả sách (có thể NULL nếu chưa trả)
    BorrowerID INT NOT NULL,       -- Khóa ngoại, liên kết với bảng Borrowers
    FOREIGN KEY (BorrowerID) REFERENCES Borrowers(BorrowerID) -- Quan hệ N-1 với Borrowers
);

GO

-- Tạo bảng Loans (bảng trung gian giữa Books và LoanSlip)
CREATE TABLE Loans (
    LoanID INT NOT NULL,           -- Khóa ngoại, liên kết với bảng LoanSlip
    BookID INT NOT NULL,           -- Khóa ngoại, liên kết với bảng Books
    PRIMARY KEY (LoanID, BookID),  -- Khóa chính là cặp (LoanID, BookID), đảm bảo không trùng lặp
    FOREIGN KEY (LoanID) REFERENCES LoanSlip(LoanID), --N-N cầu nối giữa Books và LoanSlip
    FOREIGN KEY (BookID) REFERENCES Books(BookID)--N-N cầu nối giữa Books và LoanSlip
);

GO
