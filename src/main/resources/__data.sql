-- Inserção de produtos no banco de dados por categoria
-- Ocorre automaticamente quando o spring boot é inicializado
-- se removermos o prefixo "__" do nome do arquivo.

/*  
    Por que neste arquivo teríamos que enviar ID manualmente 
    com RANDOM_UUID()? 
    
    O arquivo data.sql é um script SQL puro que o Spring roda 
    diretamente no Banco de Dados (H2) na inicialização.

    Nesse caso, o JPA/Hibernate não participa da execução do script. 
    
    O SQL é executado direto pelo driver do banco.
    
    Como a coluna id na tabela é a Chave Primária (PRIMARY KEY NOT NULL), 
    o banco exige que o valor do ID seja informado no comando INSERT.
    Por isso usamos a função nativa do H2 RANDOM_UUID(), para que o 
    próprio banco de dados gere um UUID único na hora de rodar o SQL.
*/

-- 1. ELETRÔNICOS (ELECTRONICS)
INSERT INTO product (id, name, category, price, status, description) VALUES
(RANDOM_UUID(), 'Notebook Dell Inspiron 15', 'ELECTRONICS', 3499.90, 'ativo', 'Intel Core i5, 16GB RAM, SSD 512GB, Tela 15.6 Full HD'),
(RANDOM_UUID(), 'Smartphone Samsung Galaxy S23', 'ELECTRONICS', 4199.00, 'ativo', '256GB, 8GB RAM, Câmera Tripla 50MP, 5G'),
(RANDOM_UUID(), 'Smart TV 55" 4K UHD LG', 'ELECTRONICS', 2799.00, 'ativo', 'Wi-Fi, Bluetooth, HDR, Inteligência Artificial ThinQ AI'),
(RANDOM_UUID(), 'Fone de Ouvido Bluetooth Sony WH-1000XM5', 'ELECTRONICS', 2199.90, 'ativo', 'Cancelamento de ruído ativo, bateria de até 30h'),
(RANDOM_UUID(), 'Console PlayStation 5', 'ELECTRONICS', 3899.00, 'ativo', 'SSD 825GB, com 1 Controle Sem Fio DualSense'),
(RANDOM_UUID(), 'Tablet Apple iPad 10ª Geração', 'ELECTRONICS', 3299.00, 'ativo', 'Tela Liquid Retina 10.9", 64GB, Wi-Fi');

-- 2. ROUPAS (CLOTHING)
INSERT INTO product (id, name, category, price, status, description) VALUES
(RANDOM_UUID(), 'Camiseta Premium Algodão Egípcio', 'CLOTHING', 119.90, 'ativo', '100% Algodão egípcio penteado, toque macio, corte slim fit'),
(RANDOM_UUID(), 'Calça Jeans Masculina Straight', 'CLOTHING', 189.90, 'ativo', 'Jeans de alta durabilidade com elastano para maior conforto'),
(RANDOM_UUID(), 'Jaqueta Corta Vento Esportiva', 'CLOTHING', 249.00, 'ativo', 'Resistente à água, capuz ajustável e bolsos com zíper'),
(RANDOM_UUID(), 'Vestido Midi Floral de Verão', 'CLOTHING', 159.90, 'ativo', 'Tecido leve e fluido, caimento impecável com estampa exclusiva'),
(RANDOM_UUID(), 'Moletom Canguru com Capuz Unisex', 'CLOTHING', 179.90, 'ativo', 'Algodão flanelado interno, macio e aquecido para dias frios');

-- 3. CASA & JARDIM (HOME_GARDEN)
INSERT INTO product (id, name, category, price, status, description) VALUES
(RANDOM_UUID(), 'Sofá Retrátil e Reclinável 3 Lugares', 'HOME_GARDEN', 2199.00, 'ativo', 'Tecido suede aveludado, molas ensacadas e espuma D28'),
(RANDOM_UUID(), 'Mop Giratório 360° com Balde Refil', 'HOME_GARDEN', 89.90, 'ativo', 'Facilita a limpeza da casa sem sujar as mãos, cabo telescópico'),
(RANDOM_UUID(), 'Jogo de Panelas Antiaderente 5 Peças', 'HOME_GARDEN', 299.90, 'ativo', 'Alumínio com revestimento cerâmico e tampas de vidro temperado'),
(RANDOM_UUID(), 'Kit Ferramentas de Jardinagem 5 Peças', 'HOME_GARDEN', 79.90, 'ativo', 'Pás, rastelo e tesoura de poda em aço inox com cabo ergonômico'),
(RANDOM_UUID(), 'Cafeteira Espresso Expresso Automática', 'HOME_GARDEN', 649.00, 'ativo', '15 Bar de pressão, bico vaporizador para leite e reservatório 1.5L'),
(RANDOM_UUID(), 'Robô Aspirador de Pó Inteligente', 'HOME_GARDEN', 899.00, 'ativo', 'Varre, aspira e passa pano automaticamente com sensores anti-queda');

-- 4. ESPORTES (SPORTS)
INSERT INTO product (id, name, category, price, status, description) VALUES
(RANDOM_UUID(), 'Tênis de Corrida Performance Pro', 'SPORTS', 399.90, 'ativo', 'Amortecimento em gel, cabedal respirável e solado antiderrapante'),
(RANDOM_UUID(), 'Kit Halteres Sextavados 10kg (Par)', 'SPORTS', 199.90, 'ativo', 'Par de halteres de 5kg emborrachados para treino em casa'),
(RANDOM_UUID(), 'Tapete de Yoga Antiderrapante 6mm', 'SPORTS', 89.90, 'ativo', 'Material TPE ecológico, leve, portátil com alça de transporte'),
(RANDOM_UUID(), 'Bicicleta Aro 29 Alumínio 21 Marchas', 'SPORTS', 1199.00, 'ativo', 'Freio a disco mecânico, suspensão dianteira para trilhas e cidade'),
(RANDOM_UUID(), 'Bola de Futebol Oficial de Campo', 'SPORTS', 129.90, 'ativo', 'Gomos colados termicamente, alta durabilidade e controle de trajetória');

-- 5. BRINQUEDOS (TOYS)
INSERT INTO product (id, name, category, price, status, description) VALUES
(RANDOM_UUID(), 'Kit LEGO Classic Caixa de Peças Criativas', 'TOYS', 229.90, 'ativo', '790 peças coloridas para soltar a imaginação e construir diversos modelos'),
(RANDOM_UUID(), 'Boneca Articulada Colecionável', 'TOYS', 149.90, 'ativo', 'Acompanha acessórios modernos, roupas extras e suporte de exposição'),
(RANDOM_UUID(), 'Carro de Controle Remoto 4x4 Off-Road', 'TOYS', 179.90, 'ativo', 'Escala 1:16, bateria recarregável e alta velocidade em terrenos variados'),
(RANDOM_UUID(), 'Jogo de Tabuleiro Estratégia Catan', 'TOYS', 249.90, 'ativo', 'Edição em português, ideal para partidas em família ou com amigos'),
(RANDOM_UUID(), 'Urso de Pelúcia Gigante 1 Metro', 'TOYS', 199.90, 'ativo', 'Pelúcia super macia, antialérgica e enchimento de fibra siliconada');

-- 6. BELEZA (BEAUTY)
INSERT INTO product (id, name, category, price, status, description) VALUES
(RANDOM_UUID(), 'Kit Sérum Facial Anti-idade Vitamina C', 'BEAUTY', 129.90, 'ativo', 'Ação antioxidante, uniformiza o tom da pele e reduz linhas de expressão'),
(RANDOM_UUID(), 'Perfume Importado Eau de Parfum 100ml', 'BEAUTY', 449.00, 'ativo', 'Fragrância marcante com notas amadeiradas e florais de longa fixação'),
(RANDOM_UUID(), 'Secador de Cabelo Profissional 2200W', 'BEAUTY', 259.90, 'ativo', 'Tecnologia de íons negativos, 3 temperaturas e jato de ar frio'),
(RANDOM_UUID(), 'Kit Pincéis de Maquiagem 12 Peças', 'BEAUTY', 79.90, 'ativo', 'Cerdas sintéticas extra macias, cabo de madeira com estojo organizador'),
(RANDOM_UUID(), 'Modelador de Cabelo Cacheador Automático', 'BEAUTY', 219.00, 'ativo', 'Cria cachos perfeitos em segundos com controle de temperatura inteligente');

-- 7. AUTOMOTIVO (AUTOMOTIVE)
INSERT INTO product (id, name, category, price, status, description) VALUES
(RANDOM_UUID(), 'Central Multimídia Android 7" Universal', 'AUTOMOTIVE', 599.00, 'ativo', 'Tela touch screen, GPS integrado, Bluetooth, Espelhamento Android/iOS'),
(RANDOM_UUID(), 'Câmera de Ré HD Visão Noturna', 'AUTOMOTIVE', 79.90, 'ativo', 'Resistente à água, linhas de estacionamento dinâmicas e amplo ângulo 170°'),
(RANDOM_UUID(), 'Kit Lâmpadas LED Super Branca H7', 'AUTOMOTIVE', 119.90, 'ativo', 'Iluminação de alta intensidade 6000K, maior visibilidade e segurança'),
(RANDOM_UUID(), 'Aspirador de Pó Automotivo 12V Portátil', 'AUTOMOTIVE', 89.90, 'ativo', 'Conexão acendedor de cigarro, alto poder de sucção com filtro lavável'),
(RANDOM_UUID(), 'Jogo de Tapetes Automotivos em Borracha', 'AUTOMOTIVE', 99.90, 'ativo', 'Jogo com 4 peças universais antiderrapantes e fáceis de lavar');
