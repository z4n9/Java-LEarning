    package Patterns.Prototype;

    /// Паспортные данные (ссылочный тип).
    public class Passport {
        private String passportNumber;
        private String issueDate;

        public Passport(String passportNumber, String issueDate) {
            this.passportNumber = passportNumber;
            this.issueDate = issueDate;
        }

        /// Геттеры и сеттеры
        public String getPassportNumber() {
            return passportNumber;
        }

        public void setPassportNumber(String passportNumber) {
            this.passportNumber = passportNumber;
        }

        public String getIssueDate() {
            return issueDate;
        }

        public void setIssueDate(String issueDate) {
            this.issueDate = issueDate;
        }

        @Override
        public String toString() {
            return "Passport [Number=" + passportNumber + ", Issue Date=" + issueDate + "]";
        }
    }
