insert into second_assignment.users (id, username, firstname, lastname, email, phone, timestamps, password, active) values (1, 'yer1', 'yer', 'yang', 'yvyang13',
'651', '10:36', 'lineage2', true);

insert into second_assignment.hashtag (id, label, hashtagstatus) values (1,'whatever', false);

insert into second_assignment.tweet (id, author, posted, context) values (1, 'yer', 'today', 'fuckyall');

insert into second_assignment.usertweets (users_id, tweet_id) values (1, 1);

insert into second_assignment.tweethashtags (tweet_id, hashtag_id) values (1, 1);