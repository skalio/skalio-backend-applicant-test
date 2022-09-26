/**
 * CREATE Script for init of DB
 */

-- Create 3 directories

insert into files (id, created_at, modified_at, name, size_in_bytes, deleted, mime_type)
values (1, now(), now(), 'testfolder01', 123456, false, 'inode/directory');

insert into files (id, created_at, modified_at, name, size_in_bytes, deleted, mime_type)
values (2, now(), now(), 'testfolder02', 12456, false, 'inode/directory');

insert into files (id, created_at, modified_at, name, size_in_bytes, deleted, mime_type)
values (3, now(), now(), 'testfolder03', 12346, false, 'inode/directory');

-- Create 3 files

insert into files (id, created_at, modified_at, name, size_in_bytes, deleted, mime_type)
values (4, now(), now(), 'testfile01', 126, false, 'image/jpeg');

insert into files (id, created_at, modified_at, name, size_in_bytes, deleted, mime_type)
values (5, now(), now(), 'testfile02', 125, false, 'image/png');

insert into files (id, created_at, modified_at, name, size_in_bytes, deleted, mime_type)
values (6, now(), now(), 'testfile03', 124, false, 'image/jpeg');

-- Create 1 deleted file without modified at date

insert into files (id, created_at, name, size_in_bytes, deleted, mime_type)
values (7, now(), 'testfile04', 123, true, 'video/mp4');
