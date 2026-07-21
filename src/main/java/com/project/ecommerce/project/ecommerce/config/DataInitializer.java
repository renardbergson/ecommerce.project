package com.project.ecommerce.project.ecommerce.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.ecommerce.project.ecommerce.models.Product;
import com.project.ecommerce.project.ecommerce.models.Product.Category;
import com.project.ecommerce.project.ecommerce.repository.ProductRepository;

/*  
    Como optamos por criar os produtos via Java na classe 
    DataInitializer, NÃO precisamos definir os IDs manualmente!
    
    Apenas criamos os objetos normalmente sem preencher o id, e 
    o Hibernate os gerará automaticamente, como o que ocorre ao
    inserir um produto via formulário.
*/
@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        // Inserção de produtos no banco de dados por categoria
        System.out.println("INSERÇÃO AUTOMÁTICA DE PRODUTOS INICIADA...");
        productRepository.saveAll(
            List.of(
                // 1. ELETRÔNICOS (ELECTRONICS)
                createProduct("Notebook Dell Inspiron 15", Category.ELECTRONICS, 3499.90, "ativo", "Intel Core i5, 16GB RAM, SSD 512GB, Tela 15.6 Full HD"),
                createProduct("Smartphone Samsung Galaxy S23", Category.ELECTRONICS, 4199.00, "ativo", "256GB, 8GB RAM, Câmera Tripla 50MP, 5G"),
                createProduct("Smart TV 55\" 4K UHD LG", Category.ELECTRONICS, 2799.00, "ativo", "Wi-Fi, Bluetooth, HDR, Inteligência Artificial ThinQ AI"),
                createProduct("Fone de Ouvido Bluetooth Sony WH-1000XM5", Category.ELECTRONICS, 2199.90, "ativo", "Cancelamento de ruído ativo, bateria de até 30h"),
                createProduct("Console PlayStation 5", Category.ELECTRONICS, 3899.00, "ativo", "SSD 825GB, com 1 Controle Sem Fio DualSense"),
                createProduct("Tablet Apple iPad 10ª Geração", Category.ELECTRONICS, 3299.00, "ativo", "Tela Liquid Retina 10.9\", 64GB, Wi-Fi"),

                // 2. ROUPAS (CLOTHING)
                createProduct("Camiseta Premium Algodão Egípcio", Category.CLOTHING, 119.90, "ativo", "100% Algodão egípcio penteado, toque macio, corte slim fit"),
                createProduct("Calça Jeans Masculina Straight", Category.CLOTHING, 189.90, "ativo", "Jeans de alta durabilidade com elastano para maior conforto"),
                createProduct("Jaqueta Corta Vento Esportiva", Category.CLOTHING, 249.00, "ativo", "Resistente à água, capuz ajustável e bolsos com zíper"),
                createProduct("Vestido Midi Floral de Verão", Category.CLOTHING, 159.90, "ativo", "Tecido leve e fluido, caimento impecável com estampa exclusiva"),
                createProduct("Moletom Canguru com Capuz Unisex", Category.CLOTHING, 179.90, "ativo", "Algodão flanelado interno, macio e aquecido para dias frios"),

                // 3. CASA & JARDIM (HOME_GARDEN)
                createProduct("Sofá Retrátil e Reclinável 3 Lugares", Category.HOME_GARDEN, 2199.00, "ativo", "Tecido suede aveludado, molas ensacadas e espuma D28"),
                createProduct("Mop Giratório 360° com Balde Refil", Category.HOME_GARDEN, 89.90, "ativo", "Facilita a limpeza da casa sem sujar as mãos, cabo telescópico"),
                createProduct("Jogo de Panelas Antiaderente 5 Peças", Category.HOME_GARDEN, 299.90, "ativo", "Alumínio com revestimento cerâmico e tampas de vidro temperado"),
                createProduct("Kit Ferramentas de Jardinagem 5 Peças", Category.HOME_GARDEN, 79.90, "ativo", "Pás, rastelo e tesoura de poda em aço inox com cabo ergonômico"),
                createProduct("Cafeteira Espresso Expresso Automática", Category.HOME_GARDEN, 649.00, "ativo", "15 Bar de pressão, bico vaporizador para leite e reservatório 1.5L"),
                createProduct("Robô Aspirador de Pó Inteligente", Category.HOME_GARDEN, 899.00, "ativo", "Varre, aspira e passa pano automaticamente com sensores anti-queda"),

                // 4. ESPORTES (SPORTS)
                createProduct("Tênis de Corrida Performance Pro", Category.SPORTS, 399.90, "ativo", "Amortecimento em gel, cabedal respirável e solado antiderrapante"),
                createProduct("Kit Halteres Sextavados 10kg (Par)", Category.SPORTS, 199.90, "ativo", "Par de halteres de 5kg emborrachados para treino em casa"),
                createProduct("Tapete de Yoga Antiderrapante 6mm", Category.SPORTS, 89.90, "ativo", "Material TPE ecológico, leve, portátil com alça de transporte"),
                createProduct("Bicicleta Aro 29 Alumínio 21 Marchas", Category.SPORTS, 1199.00, "ativo", "Freio a disco mecânico, suspensão dianteira para trilhas e cidade"),
                createProduct("Bola de Futebol Oficial de Campo", Category.SPORTS, 129.90, "ativo", "Gomos colados termicamente, alta durabilidade e controle de trajetória"),

                // 5. BRINQUEDOS (TOYS)
                createProduct("Kit LEGO Classic Caixa de Peças Criativas", Category.TOYS, 229.90, "ativo", "790 peças coloridas para soltar a imaginação e construir diversos modelos"),
                createProduct("Boneca Articulada Colecionável", Category.TOYS, 149.90, "ativo", "Acompanha acessórios modernos, roupas extras e suporte de exposição"),
                createProduct("Carro de Controle Remoto 4x4 Off-Road", Category.TOYS, 179.90, "ativo", "Escala 1:16, bateria recarregável e alta velocidade em terrenos variados"),
                createProduct("Jogo de Tabuleiro Estratégia Catan", Category.TOYS, 249.90, "ativo", "Edição em português, ideal para partidas em família ou com amigos"),
                createProduct("Urso de Pelúcia Gigante 1 Metro", Category.TOYS, 199.90, "ativo", "Pelúcia super macia, antialérgica e enchimento de fibra siliconada"),

                // 6. BELEZA (BEAUTY)
                createProduct("Kit Sérum Facial Anti-idade Vitamina C", Category.BEAUTY, 129.90, "ativo", "Ação antioxidante, uniformiza o tom da pele e reduz linhas de expressão"),
                createProduct("Perfume Importado Eau de Parfum 100ml", Category.BEAUTY, 449.00, "ativo", "Fragrância marcante com notas amadeiradas e florais de longa fixação"),
                createProduct("Secador de Cabelo Profissional 2200W", Category.BEAUTY, 259.90, "ativo", "Tecnologia de íons negativos, 3 temperaturas e jato de ar frio"),
                createProduct("Kit Pincéis de Maquiagem 12 Peças", Category.BEAUTY, 79.90, "ativo", "Cerdas sintéticas extra macias, cabo de madeira com estojo organizador"),
                createProduct("Modelador de Cabelo Cacheador Automático", Category.BEAUTY, 219.00, "ativo", "Cria cachos perfeitos em segundos com controle de temperatura inteligente"),

                // 7. AUTOMOTIVO (AUTOMOTIVE)
                createProduct("Central Multimídia Android 7\" Universal", Category.AUTOMOTIVE, 599.00, "ativo", "Tela touch screen, GPS integrado, Bluetooth, Espelhamento Android/iOS"),
                createProduct("Câmera de Ré HD Visão Noturna", Category.AUTOMOTIVE, 79.90, "ativo", "Resistente à água, linhas de estacionamento dinâmicas e amplo ângulo 170°"),
                createProduct("Kit Lâmpadas LED Super Branca H7", Category.AUTOMOTIVE, 119.90, "ativo", "Iluminação de alta intensidade 6000K, maior visibilidade e segurança"),
                createProduct("Aspirador de Pó Automotivo 12V Portátil", Category.AUTOMOTIVE, 89.90, "ativo", "Conexão acendedor de cigarro, alto poder de sucção com filtro lavável"),
                createProduct("Jogo de Tapetes Automotivos em Borracha", Category.AUTOMOTIVE, 99.90, "ativo", "Jogo com 4 peças universais antiderrapantes e fáceis de lavar")
            )
        );
    }

    private Product createProduct(String name, Category category, Double price, String status, String description) {
        Product product = new Product();
        product.setName(name);
        product.setCategory(category);
        product.setPrice(price);
        product.setStatus(status);
        product.setDescription(description);
        return product;
    }
}
