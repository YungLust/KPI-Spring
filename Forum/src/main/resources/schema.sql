-- Create sequences only if they don't exist
CREATE SEQUENCE IF NOT EXISTS user_seq START 1;
CREATE SEQUENCE IF NOT EXISTS topic_seq START 1;
CREATE SEQUENCE IF NOT EXISTS post_seq START 1;

-- Users table
CREATE TABLE IF NOT EXISTS users (
    id INT PRIMARY KEY DEFAULT nextval('user_seq'),
    name TEXT NOT NULL,
    status TEXT NOT NULL
    );

-- Topics table
CREATE TABLE IF NOT EXISTS topics (
    id INT PRIMARY KEY DEFAULT nextval('topic_seq'),
    user_id INT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    title TEXT NOT NULL,
    description TEXT
    );

-- Posts table
CREATE TABLE IF NOT EXISTS posts (
    id INT PRIMARY KEY DEFAULT nextval('post_seq'),
    topic_id INT NOT NULL REFERENCES topics(id) ON DELETE CASCADE,
    user_id INT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    text TEXT NOT NULL
    );
