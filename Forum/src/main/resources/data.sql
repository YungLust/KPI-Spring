-- Users
INSERT INTO users (id, name, status) VALUES
                                         (1, 'philia', 'ADMIN'),
                                         (2, 'Kaiser', 'USER'),
                                         (3, 'blue cat', 'NEWBIE')
    ON CONFLICT (id) DO NOTHING;

-- Topics
INSERT INTO topics (id, user_id, title, description) VALUES
                                                         (1, 1, 'What is the forum about', 'Starter post'),
                                                         (2, 3, 'I am new here', NULL)
    ON CONFLICT (id) DO NOTHING;

-- Posts
INSERT INTO posts (id, topic_id, user_id, text) VALUES
                                                    (1, 1, 1, 'Hello everyone. I am philia'),
                                                    (2, 1, 1, 'The rule here is: love Lily'),
                                                    (3, 2, 3, 'Hello everyone!')
    ON CONFLICT (id) DO NOTHING;
