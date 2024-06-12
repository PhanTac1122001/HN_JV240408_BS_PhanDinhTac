package Basic;

import java.util.Scanner;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    public String description;
    public double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus;


    public Book() {
    }

    public Book(int bookId, String bookName, String author, String description, double importPrice, double exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.description = description;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData(Scanner scanner) {

        this.bookId = inputBookId();

        this.bookName = inputBookName(scanner);

        this.author = inputAuthor(scanner);

        this.description = inputDescription(scanner);

        this.importPrice = inputImportPrice(scanner);

        this.exportPrice = inputExportPrice(scanner);

        this.interest = inputInterest(importPrice, exportPrice);

        this.bookStatus = inputBookStatus(scanner);
    }

    public void updateData(Scanner scanner) {
        this.bookName = inputBookName(scanner);
        this.author = inputAuthor(scanner);
        this.description = inputDescription(scanner);
        this.importPrice = inputImportPrice(scanner);
        this.exportPrice = inputExportPrice(scanner);
        this.interest = inputInterest(importPrice, exportPrice);
        this.bookStatus = inputBookStatus(scanner);
    }


    public int inputBookId() {
        if (BookManagement.indexBook == 0) {
            return 1;
        } else {
            int maxId = BookManagement.arrBook[0].getBookId();
            for (int i = 0; i < BookManagement.indexBook; i++) {
                if (maxId < BookManagement.arrBook[i].getBookId()) {
                    maxId = BookManagement.arrBook[i].getBookId();
                }
            }
            return maxId + 1;
        }
    }

    public String inputBookName(Scanner scanner) {
        System.out.println("Mời nhập vào tên sách: ");
        do {
            String bookName = scanner.nextLine();
            if (bookName.trim().isEmpty()) {
                System.err.println("Tên sách không được để trống");
            } else {
                if (bookName.length() >= 4 && bookName.length() <= 50) {
                    return bookName;
                } else {
                    System.err.println("Tên sách phai nhập từ 4 đến 50 ký tự");
                }
            }
        } while (true);
    }

    public String inputAuthor(Scanner scanner) {
        System.out.println("Mời nhập vào tên tác giả: ");
        do {
            String author = scanner.nextLine();
            if (author.trim().isEmpty()) {
                System.err.println("Tên tác giả không được để trống");
            } else {
                return author;
            }
        } while (true);
    }


    public String inputDescription(Scanner scanner) {
        System.out.println("Mời nhập vào mô tả sách: ");
        do {
            String description = scanner.nextLine();
            if (description.trim().isEmpty()) {
                System.err.println("Mô tả sách không được để trống");
            } else {
                if (description.length() >= 10) {
                    return description;
                } else {
                    System.err.println("Mô tả sách phải nhập ít nhất 10 ký tự");
                }
            }
        } while (true);
    }

    public double inputImportPrice(Scanner scanner) {
        System.out.println("Mời nhập vào giá nhập của sách:");
        do {
            double importPrice = Double.parseDouble(scanner.nextLine());
            if (importPrice > 0) {
                return importPrice;
            } else {
                System.err.println("Giá nhập của sách có giá trị lớn hơn 0,vui lòng nhập lại");
            }
        } while (true);
    }


    public double inputExportPrice(Scanner scanner) {
        System.out.println("Mời nhập vào giá xuất của sách");
        do {
            double exportPrice = Double.parseDouble(scanner.nextLine());
            if (exportPrice >= importPrice * 1.2) {
                return exportPrice;
            } else {
                System.err.println("Giá xuất của sách có giá trị lớn hơn ít nhất 20% so với giá nhập, vui lòng nhập lại");
            }
        } while (true);
    }


    public float inputInterest(double importPrice, double exportPrice) {
        return (float) (exportPrice - importPrice);
    }

    public boolean inputBookStatus(Scanner scanner) {
        System.out.println("Mời nhập vào trang thái sách");
        do {
            String status = scanner.nextLine();
            if (status.equals("true") || status.equals("false")) {
                return Boolean.parseBoolean(status);
            } else {
                System.err.println("Trạng thái sách chỉ nhận giá trị true | false, vui lòng nhập lại");
            }
        } while (true);
    }

    public void displayData() {
        System.out.printf("Mã sách: %s - Tên sách: %s -Tên tác giả: %s - Giá nhập: %s - Giá xuất: %s - Lợi nhuận: %s - Trạng thái: %s\n",
                this.bookId,
                this.bookName,
                this.author,
                this.importPrice,
                this.exportPrice,
                this.interest,
                this.bookStatus ? "Đang bán" : "Không bán");

        System.out.printf("Mô tả: %s \n", this.description);
        System.out.println("-------------------------------------------------------------------------------------------");
    }
}
