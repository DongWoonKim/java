-- member 테이블에 role 열 추가
ALTER TABLE member
    ADD COLUMN role VARCHAR(20) NOT NULL DEFAULT 'ROLE_USER';