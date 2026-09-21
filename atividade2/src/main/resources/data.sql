-- ==========================================
-- CATEGORIAS
-- ==========================================

INSERT INTO categoria (nome, descricao) VALUES
('Ficção', 'Livros de ficção e literatura'),
('Tecnologia', 'Livros sobre tecnologia e programação'),
('História', 'Livros relacionados à história'),
('Romance', 'Romances e literatura romântica');


-- ==========================================
-- AUTORES
-- ==========================================

INSERT INTO autor (nome, data_nascimento, nacionalidade, biografia) VALUES
('Machado de Assis', '1839-06-21', 'Brasileira',
 'Escritor brasileiro, considerado um dos grandes nomes da literatura brasileira.'),

('J. R. R. Tolkien', '1892-01-03', 'Britânica',
 'Escritor britânico conhecido por suas obras de fantasia.'),

('Robert C. Martin', '1952-12-05', 'Americana',
 'Autor e engenheiro de software conhecido por seus trabalhos sobre desenvolvimento de software.'),

('Yuval Noah Harari', '1976-02-24', 'Israelense',
 'Historiador e autor de obras sobre história e sociedade.');


-- ==========================================
-- LIVROS
-- ==========================================

INSERT INTO livro
(isbn, titulo, editora, ano_publicacao, numero_paginas,
 quantidade_total, quantidade_disponivel, categoria_id)
VALUES

('9780000000001',
 'Dom Casmurro',
 'Editora Clássicos',
 1899,
 256,
 5,
 3,
 1),

('9780000000002',
 'Memórias Póstumas de Brás Cubas',
 'Editora Clássicos',
 1881,
 240,
 4,
 4,
 1),

('9780000000003',
 'O Hobbit',
 'HarperCollins',
 1937,
 310,
 6,
 2,
 1),

('9780000000004',
 'Clean Code',
 'Prentice Hall',
 2008,
 464,
 5,
 5,
 2),

('9780000000005',
 'O Senhor dos Anéis',
 'HarperCollins',
 1954,
 1178,
 3,
 0,
 1),

('9780000000006',
 'Sapiens',
 'Companhia das Letras',
 2011,
 464,
 4,
 4,
 3),

('9780000000007',
 'Livro de Teste',
 'Editora Teste',
 2020,
 200,
 2,
 1,
 4);


-- ==========================================
-- LIVRO_AUTOR
-- ==========================================

INSERT INTO livro_autor (livro_id, autor_id) VALUES
(1, 1), -- Dom Casmurro -> Machado
(2, 1), -- Memórias Póstumas -> Machado
(3, 2), -- O Hobbit -> Tolkien
(4, 3), -- Clean Code -> Robert Martin
(5, 2), -- Senhor dos Anéis -> Tolkien
(6, 4), -- Sapiens -> Harari
(7, 1); -- Livro de Teste -> Machado


-- ==========================================
-- USUÁRIOS
-- ==========================================

INSERT INTO usuario
(nome, cpf, email, telefone, data_cadastro, endereco, ativo)
VALUES

('João Silva',
 '11111111111',
 'joao.silva@email.com',
 '84999990001',
 '2026-01-10',
 'Rua A, 100',
 true),

('Maria Silva Santos',
 '22222222222',
 'maria.santos@email.com',
 '84999990002',
 '2026-02-15',
 'Rua B, 200',
 true),

('Carlos Oliveira',
 '33333333333',
 'carlos@email.com',
 '84999990003',
 '2026-03-20',
 'Rua C, 300',
 true),

('Ana Souza',
 '44444444444',
 'ana@email.com',
 '84999990004',
 '2026-04-05',
 'Rua D, 400',
 false);


-- ==========================================
-- EMPRÉSTIMOS
-- ==========================================

INSERT INTO emprestimo
(usuario_id,
 data_emprestimo,
 data_devolucao_prevista,
 data_devolucao_efetiva,
 status,
 valor_multa)
VALUES

-- Empréstimo ativo normal
(1,
 '2026-09-10',
 '2026-09-25',
 NULL,
 'ATIVO',
 0.00),

-- Empréstimo atrasado
(1,
 '2026-09-01',
 '2026-09-10',
 NULL,
 'ATIVO',
 5.00),

-- Empréstimo devolvido
(2,
 '2026-08-01',
 '2026-08-15',
 '2026-08-14',
 'DEVOLVIDO',
 0.00),

-- Outro empréstimo ativo
(2,
 '2026-09-12',
 '2026-09-20',
 NULL,
 'ATIVO',
 0.00),

-- Outro atrasado
(3,
 '2026-08-20',
 '2026-09-05',
 NULL,
 'ATIVO',
 10.00);


-- ==========================================
-- ITEM_EMPRESTIMO
-- ==========================================

INSERT INTO item_emprestimo
(emprestimo_id, livro_id)
VALUES

-- Empréstimo 1
(1, 1),
(1, 3),

-- Empréstimo 2 - atrasado
(2, 4),
(2, 6),

-- Empréstimo 3 - devolvido
(3, 2),

-- Empréstimo 4
(4, 5),

-- Empréstimo 5 - atrasado
(5, 3);
