-- DROP TABLE IF EXISTS  FOLDER;
--
-- CREATE TABLE FOLDER (
--     FOLDER_ID BIGINT GENERATED ALWAYS AS IDENTITY,
--     FOLDER_NAME TEXT NOT NULL,
--     TOOLBAR_FOLDER BOOLEAN,
--     PARENT BIGINT,
--     CREATE_DATE TIMESTAMP NOT NULL,
--     MODIFIED_DATE TIMESTAMP NOT NULL,
--     CONSTRAINT PRI_FOLDER_ID PRIMARY KEY (FOLDER_ID),
--     CONSTRAINT FOR_FOLDER_PARENT_FOLDER_FOLDER_ID FOREIGN KEY (PARENT)
--         REFERENCES FOLDER(FOLDER_ID));
