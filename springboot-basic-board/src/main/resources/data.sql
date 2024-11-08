-- user 테이블 생성
CREATE TABLE user (
                      id BIGINT NOT NULL AUTO_INCREMENT,
                      name VARCHAR(20),
                      email VARCHAR(50),
                      userId VARCHAR(50),
                      password VARCHAR(100),
                      role ENUM('ROLE_USER', 'ROLE_ADMIN') DEFAULT 'ROLE_USER',
                      PRIMARY KEY (id)
);

-- member 테이블 생성
CREATE TABLE member (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        user_id VARCHAR(30) NOT NULL,
                        password VARCHAR(50) NOT NULL,
                        user_name VARCHAR(10) NOT NULL
);

-- article 테이블 생성
CREATE TABLE article (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         user_id VARCHAR(30) NOT NULL,
                         title VARCHAR(100) NOT NULL,
                         content TEXT NOT NULL,
                         created DATETIME DEFAULT CURRENT_TIMESTAMP,
                         updated DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO article (user_id, title, content) VALUES
                                                  ('user1', '게시글 1', '이것은 게시글 1의 내용입니다.'),
                                                  ('user2', '게시글 2', '이것은 게시글 2의 내용입니다.'),
                                                  ('user3', '게시글 3', '이것은 게시글 3의 내용입니다.'),
                                                  ('user4', '게시글 4', '이것은 게시글 4의 내용입니다.'),
                                                  ('user5', '게시글 5', '이것은 게시글 5의 내용입니다.'),
                                                  ('user1', '게시글 6', '이것은 게시글 6의 내용입니다.'),
                                                  ('user2', '게시글 7', '이것은 게시글 7의 내용입니다.'),
                                                  ('user3', '게시글 8', '이것은 게시글 8의 내용입니다.'),
                                                  ('user4', '게시글 9', '이것은 게시글 9의 내용입니다.'),
                                                  ('user5', '게시글 10', '이것은 게시글 10의 내용입니다.'),
                                                  ('user1', '게시글 11', '이것은 게시글 11의 내용입니다.'),
                                                  ('user2', '게시글 12', '이것은 게시글 12의 내용입니다.'),
                                                  ('user3', '게시글 13', '이것은 게시글 13의 내용입니다.'),
                                                  ('user4', '게시글 14', '이것은 게시글 14의 내용입니다.'),
                                                  ('user5', '게시글 15', '이것은 게시글 15의 내용입니다.'),
                                                  ('user1', '게시글 16', '이것은 게시글 16의 내용입니다.'),
                                                  ('user2', '게시글 17', '이것은 게시글 17의 내용입니다.'),
                                                  ('user3', '게시글 18', '이것은 게시글 18의 내용입니다.'),
                                                  ('user4', '게시글 19', '이것은 게시글 19의 내용입니다.'),
                                                  ('user5', '게시글 20', '이것은 게시글 20의 내용입니다.'),
                                                  ('user1', '게시글 21', '이것은 게시글 21의 내용입니다.'),
                                                  ('user2', '게시글 22', '이것은 게시글 22의 내용입니다.'),
                                                  ('user3', '게시글 23', '이것은 게시글 23의 내용입니다.'),
                                                  ('user4', '게시글 24', '이것은 게시글 24의 내용입니다.'),
                                                  ('user5', '게시글 25', '이것은 게시글 25의 내용입니다.'),
                                                  ('user1', '게시글 26', '이것은 게시글 26의 내용입니다.'),
                                                  ('user2', '게시글 27', '이것은 게시글 27의 내용입니다.'),
                                                  ('user3', '게시글 28', '이것은 게시글 28의 내용입니다.'),
                                                  ('user4', '게시글 29', '이것은 게시글 29의 내용입니다.'),
                                                  ('user5', '게시글 30', '이것은 게시글 30의 내용입니다.'),
                                                  ('user1', '게시글 31', '이것은 게시글 31의 내용입니다.'),
                                                  ('user2', '게시글 32', '이것은 게시글 32의 내용입니다.'),
                                                  ('user3', '게시글 33', '이것은 게시글 33의 내용입니다.'),
                                                  ('user4', '게시글 34', '이것은 게시글 34의 내용입니다.'),
                                                  ('user5', '게시글 35', '이것은 게시글 35의 내용입니다.');