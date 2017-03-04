DROP TABLE Accountant IF EXISTS;

CREATE TABLE Accountant (
  Id               INTEGER PRIMARY KEY,
  Name             VARCHAR(250)  NOT NULL,
  Document         VARCHAR(15)   NOT NULL,
  AgencyCode       VARCHAR(6)    NOT NULL,
  AccountNumber    VARCHAR(10)   NOT NULL,
  BalanceAvailable DECIMAL(12,2) NOT NULL
);

DROP TABLE ElectronicTransfer IF EXISTS;

CREATE TABLE ElectronicTransfer (
  Id              INTEGER IDENTITY PRIMARY KEY,
  AccountantFrom  INTEGER NOT NULL,
  AccountantTo    INTEGER NOT NULL,
  TransferValue   DECIMAL(12,2) NOT NULL,
  TransferDate    DATE NOT NULL,
  FOREIGN KEY (AccountantFrom) REFERENCES Accountant(Id),
  FOREIGN KEY (AccountantTo) REFERENCES Accountant(Id)
);