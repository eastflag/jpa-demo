CREATE TABLE app_user
(
    id       BIGINT       NOT NULL,
    name     VARCHAR(255) NOT NULL,
    password VARCHAR(255),
    CONSTRAINT pk_app_user PRIMARY KEY (id)
);

CREATE TABLE project
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name       VARCHAR(255)                            NOT NULL,
    start_date date,
    manager_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_project PRIMARY KEY (id)
);

CREATE TABLE task
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name        VARCHAR(255)                            NOT NULL,
    start_date  TIMESTAMP WITHOUT TIME ZONE,
    end_date    TIMESTAMP WITHOUT TIME ZONE,
    assignee_id BIGINT,
    project_id  BIGINT,
    CONSTRAINT pk_task PRIMARY KEY (id)
);

ALTER TABLE project
    ADD CONSTRAINT FK_PROJECT_ON_MANAGER FOREIGN KEY (manager_id) REFERENCES app_user (id);

ALTER TABLE task
    ADD CONSTRAINT FK_TASK_ON_ASSIGNEE FOREIGN KEY (assignee_id) REFERENCES app_user (id);

ALTER TABLE task
    ADD CONSTRAINT FK_TASK_ON_PROJECT FOREIGN KEY (project_id) REFERENCES project (id);
