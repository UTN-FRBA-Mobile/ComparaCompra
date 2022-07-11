package com.mobile.ComparaCompra.service;

import com.mobile.ComparaCompra.domain.Market;
import com.mobile.ComparaCompra.domain.Product;
import com.mobile.ComparaCompra.domain.ProductXMarket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService
{
    List<ProductXMarket> productList = new ArrayList<>();
    List<Market> marketList = new ArrayList<>();

    @Autowired
    public ProductServiceImpl()
    {
        Product productA = new Product(1,"Galletitas Oreo 118 Gr.", "https://ardiaprod.vteximg.com.br/arquivos/ids/223498-1000-1000/Galletitas-Oreo-118-Gr-_1.jpg", "111111111");
        Product productB = new Product(2,"Papas fritas DIA Original 150 Gr.", "https://ardiaprod.vteximg.com.br/arquivos/ids/220181-1000-1000/Papas-Fritas-Tubo-DIA-Sabor-Original-150-Gr-_1.jpg", "222222222");
        Product productC = new Product(3,"Pañuelos ELITE Doble Hoja Caja 100 Unidades", "https://static.cotodigital3.com.ar/sitios/fotos/full/00264600/00264677.jpg", "111111112");
        Product productD = new Product(4,"Rollos De Cocina Familiar 200 P Sussex Rol 4.12 Mtr", "https://static.cotodigital3.com.ar/sitios/fotos/full/00521500/00521586.jpg", "111111113");
        Product productE = new Product(5,"Alfajor Dulce de Leche Terrabusi 50gr.", "https://static.cotodigital3.com.ar/sitios/fotos/full/00140200/00140272.jpg", "111111122"); 
        Product productF = new Product(6,"Gaseosa CUNNINGTON Sin Azúcar Botella 1.5 L", "https://static.cotodigital3.com.ar/sitios/fotos/full/00180400/00180414.jpg", "111112122");
        Product productG = new Product(7,"Alfajor MILKA Oreo Chocolate 61gr.", "https://static.cotodigital3.com.ar/sitios/fotos/full/00267700/00267716.jpg", "111111133");
        Product productH = new Product(8,"Café Molido LA VIRGINIA Paquete 250 Gr", "https://static.cotodigital3.com.ar/sitios/fotos/full/00230100/00230124.jpg", "111111134");        
        Product productI = new Product(9,"Mini-Alfajor Rellenos Dulce Jorgito Paq 160gr.", "https://static.cotodigital3.com.ar/sitios/fotos/full/00223600/00223660.jpg", "111111132");
        Product productJ = new Product(10,"Gaseosa COTO Naranja Botella 2.25 L", "https://static.cotodigital3.com.ar/sitios/fotos/full/00457200/00457205.jpg", "121212122");
        Product productK = new Product(11,"Gaseosa CUNNINGTON Botella 1.5 L", "https://static.cotodigital3.com.ar/sitios/fotos/full/00180300/00180361.jpg", "111111131");
        Product productL = new Product(12,"Gaseosa CUNNINGTON Pomelo Botella 3 L", "https://static.cotodigital3.com.ar/sitios/fotos/full/00460400/00460484.jpg", "111111134");
        Product productM = new Product(13,"Cafe Molido Torrado Intens Morenita Paq 500 Grm", "https://static.cotodigital3.com.ar/sitios/fotos/full/00514000/00514018.jpg", "111211135");
        Product productN = new Product(14,"Queso Vegano Cheddar En Fetas Felices Las Vacas Paq 200gr", "https://static.cotodigital3.com.ar/sitios/fotos/full/00533300/00533337.jpg", "111111135");
        Product productO = new Product(15,"Queso Manchego Semi Curado Maese Miguel Fwp 150gr", "https://static.cotodigital3.com.ar/sitios/fotos/full/00533300/00533336.jpg", "111111136");
        Product productP = new Product(16,"Cerveza QUILMES Botella 970 Cc", "https://static.cotodigital3.com.ar/sitios/fotos/full/00005000/00005098_g01.jpg", "112111136");
        Product productQ = new Product(17,"Jabón En Polvo Zorro Clearsist.Antimanchas Paq 350gr", "https://static.cotodigital3.com.ar/sitios/fotos/full/00499400/00499491.jpg", "111111137");
        Product productR = new Product(18,"Jabón Líquido Matic Drive Colores Radiantes 3 L", "https://static.cotodigital3.com.ar/sitios/fotos/full/00511000/00511006.jpg", "111111138");
        Product productS = new Product(19,"Salchicha Clasica VIENISSIMA Paq 1 Grm", "https://static.cotodigital3.com.ar/sitios/fotos/full/00299000/00299037.jpg", "112111138");
        Product productT = new Product(20,"Medallones CHAMPION 4 Uni X 56gr", "https://static.cotodigital3.com.ar/sitios/fotos/full/00499100/00499121.jpg", "111111139");
        Product productU = new Product(21,"Desodorante AXE Dark Temptation En Aerosol 150 Ml", "https://static.cotodigital3.com.ar/sitios/fotos/full/00510200/00510206_g01.jpg", "111111140");
        Product productV = new Product(22,"Mayonesa DIA 900 Ml.", "https://ardiaprod.vteximg.com.br/arquivos/ids/184238-1000-1000/Mayonesa-DIA-900-Ml-_1.jpg", "112111140");
        Product productW = new Product(23,"Pure De Tomate COTO Con Orégano Tetrabrik 520gr", "https://static.cotodigital3.com.ar/sitios/fotos/full/00457000/00457065.jpg", "111111141");
        Product productX = new Product(24,"Lomitos de atún Carrefour en aceite 170 g.", "https://carrefourar.vtexassets.com/arquivos/ids/188365-1200-auto?v=637474618542900000&width=1200&height=auto&aspect=true", "111111141");
        Product productY = new Product(25,"Flautita Congelada X Unidad", "https://static.cotodigital3.com.ar/sitios/fotos/full/00012100/00012179.jpg", "111111188");
        Product productZ = new Product(26,"Agua Mineral Natural COTO Bidón 6.5 L", "https://static.cotodigital3.com.ar/sitios/fotos/full/00292800/00292804.jpg", "111111142");
        Product productAA = new Product(27,"Azúcar común Carrefour tipo A bolsa 1 kg", "https://carrefourar.vtexassets.com/arquivos/ids/233106-800-auto?v=637775941788030000", "111111143");
        Product productAB = new Product(28,"Medialuna De Manteca", "https://static.cotodigital3.com.ar/sitios/fotos/full/00000900/00000937.jpg", "111111511");
        Product productAC = new Product(29,"Sandwich Simple Litoral Coto 1 Uni", "https://static.cotodigital3.com.ar/sitios/fotos/full/00010600/00010630.jpg", "111111512");
        Product productAD = new Product(30,"Prepizza Mixta COTO", "https://static.cotodigital3.com.ar/sitios/fotos/full/00044100/00044108.jpg", "111111513");
        Product productAE = new Product(31,"Figazzita Arabe Petit COTO X Kg", "https://static.cotodigital3.com.ar/sitios/fotos/full/00044400/00044466.jpg", "111111514");
        Product productAF = new Product(32,"Galletitas pepas Carrefour 500 g.", "https://carrefourar.vtexassets.com/arquivos/ids/175944-1200-auto?v=637468571970070000", "112111514");

        ProductXMarket PA1 = new ProductXMarket(productA,1,178.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PC1 = new ProductXMarket(productC,1,139.91,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PD1 = new ProductXMarket(productD,1,294.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PE1 = new ProductXMarket(productE,1,102.49,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PF1 = new ProductXMarket(productF,1,56.19,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PG1 = new ProductXMarket(productG,1,138.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PH1 = new ProductXMarket(productH,1,388.15,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PI1 = new ProductXMarket(productI,1,293.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PJ1 = new ProductXMarket(productJ,1,158.89,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PK1 = new ProductXMarket(productK,1,56.19,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PM1 = new ProductXMarket(productM,1,839.8,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PN1 = new ProductXMarket(productN,1,429,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PO1 = new ProductXMarket(productO,1,968.95,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PP1 = new ProductXMarket(productP,1,124,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PQ1 = new ProductXMarket(productQ,1,59.47,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PR1 = new ProductXMarket(productR,1,803.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PS1 = new ProductXMarket(productS,1,267.5,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PT1 = new ProductXMarket(productT,1,249,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PU1 = new ProductXMarket(productU,1,296.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PW1 = new ProductXMarket(productW,1,97.52,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PY1 = new ProductXMarket(productY,1,35,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PZ1 = new ProductXMarket(productZ,1,255,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAB1 = new ProductXMarket(productAB,1,39.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAC1 = new ProductXMarket(productAC,1,65,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAD1 = new ProductXMarket(productAD,1,140,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAE1 = new ProductXMarket(productAE,1,160,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        
        ProductXMarket PA4 = new ProductXMarket(productA,4,178.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PC4 = new ProductXMarket(productC,4,139.91,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PD4 = new ProductXMarket(productD,4,294.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PE4 = new ProductXMarket(productE,4,102.49,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PF4 = new ProductXMarket(productF,4,56.19,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PG4 = new ProductXMarket(productG,4,138.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PH4 = new ProductXMarket(productH,4,388.15,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PJ4 = new ProductXMarket(productJ,4,158.89,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PK4 = new ProductXMarket(productK,4,56.19,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PM4 = new ProductXMarket(productM,4,839.8,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PO4 = new ProductXMarket(productO,4,968.95,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PP4 = new ProductXMarket(productP,4,124,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PQ4 = new ProductXMarket(productQ,4,59.47,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PR4 = new ProductXMarket(productR,4,803.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PS4 = new ProductXMarket(productS,4,267.5,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PT4 = new ProductXMarket(productT,4,249,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PU4 = new ProductXMarket(productU,4,296.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PW4 = new ProductXMarket(productW,4,97.52,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PY4 = new ProductXMarket(productY,4,35,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAB4 = new ProductXMarket(productAB,4,39.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAC4 = new ProductXMarket(productAC,4,65,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAD4 = new ProductXMarket(productAD,4,140,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAE4 = new ProductXMarket(productAE,4,160,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        
        ProductXMarket PA6 = new ProductXMarket(productA,6,175.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PC6 = new ProductXMarket(productC,6,136.91,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PD6 = new ProductXMarket(productD,6,291.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PE6 = new ProductXMarket(productE,6,100.49,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PF6 = new ProductXMarket(productF,6,53.19,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PG6 = new ProductXMarket(productG,6,135.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PH6 = new ProductXMarket(productH,6,385.15,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PI6 = new ProductXMarket(productI,6,290.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PJ6 = new ProductXMarket(productJ,6,155.89,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PK6 = new ProductXMarket(productK,6,53.19,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PM6 = new ProductXMarket(productM,6,836.8,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PN6 = new ProductXMarket(productN,6,426,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PO6 = new ProductXMarket(productO,6,965.95,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PP6 = new ProductXMarket(productP,6,121,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PQ6 = new ProductXMarket(productQ,6,56.47,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PR6 = new ProductXMarket(productR,6,800.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PS6 = new ProductXMarket(productS,6,264.5,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PT6 = new ProductXMarket(productT,6,246,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PU6 = new ProductXMarket(productU,6,293.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PW6 = new ProductXMarket(productW,6,94.52,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PY6 = new ProductXMarket(productY,6,32,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PZ6 = new ProductXMarket(productZ,6,252,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAB6 = new ProductXMarket(productAB,6,36.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAC6 = new ProductXMarket(productAC,6,62,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAD6 = new ProductXMarket(productAD,6,137,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAE6 = new ProductXMarket(productAE,6,157,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        
        ProductXMarket PA7 = new ProductXMarket(productA,7,181.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PC7 = new ProductXMarket(productC,7,142.91,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PD7 = new ProductXMarket(productD,7,297.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PE7 = new ProductXMarket(productE,7,105.49,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PF7 = new ProductXMarket(productF,7,59.19,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PG7 = new ProductXMarket(productG,7,141.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PH7 = new ProductXMarket(productH,7,391.15,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PJ7 = new ProductXMarket(productJ,7,161.89,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PK7 = new ProductXMarket(productK,7,59.19,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PM7 = new ProductXMarket(productM,7,842.8,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PO7 = new ProductXMarket(productO,7,971.95,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PP7 = new ProductXMarket(productP,7,127,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PQ7 = new ProductXMarket(productQ,7,62.47,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PR7 = new ProductXMarket(productR,7,806.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PS7 = new ProductXMarket(productS,7,280.5,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PT7 = new ProductXMarket(productT,7,252,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PU7 = new ProductXMarket(productU,7,299.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PW7 = new ProductXMarket(productW,7,100.52,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PY7 = new ProductXMarket(productY,7,38,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAB7 = new ProductXMarket(productAB,7,42.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAC7 = new ProductXMarket(productAC,7,68,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAD7 = new ProductXMarket(productAD,7,143,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAE7 = new ProductXMarket(productAE,7,163,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        
        ProductXMarket PA8 = new ProductXMarket(productA,8,178.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PC8 = new ProductXMarket(productC,8,139.91,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PD8 = new ProductXMarket(productD,8,294.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PE8 = new ProductXMarket(productE,8,102.49,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PF8 = new ProductXMarket(productF,8,56.19,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PG8 = new ProductXMarket(productG,8,138.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PH8 = new ProductXMarket(productH,8,388.15,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PI8 = new ProductXMarket(productI,8,293.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PJ8 = new ProductXMarket(productJ,8,158.89,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PK8 = new ProductXMarket(productK,8,56.19,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PM8 = new ProductXMarket(productM,8,839.8,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PN8 = new ProductXMarket(productN,8,429,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PO8 = new ProductXMarket(productO,8,968.95,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PP8 = new ProductXMarket(productP,8,124,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PQ8 = new ProductXMarket(productQ,8,59.47,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PR8 = new ProductXMarket(productR,8,803.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PS8 = new ProductXMarket(productS,8,267.5,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PT8 = new ProductXMarket(productT,8,249,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PU8 = new ProductXMarket(productU,8,296.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PW8 = new ProductXMarket(productW,8,97.52,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PY8 = new ProductXMarket(productY,8,35,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PZ8 = new ProductXMarket(productZ,8,255,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAB8 = new ProductXMarket(productAB,8,39.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAC8 = new ProductXMarket(productAC,8,65,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAD8 = new ProductXMarket(productAD,8,140,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAE8 = new ProductXMarket(productAE,8,160,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        
        ProductXMarket PA9 = new ProductXMarket(productA,9,178.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PC9 = new ProductXMarket(productC,9,139.91,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PD9 = new ProductXMarket(productD,9,294.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PE9 = new ProductXMarket(productE,9,102.49,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PF9 = new ProductXMarket(productF,9,56.19,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PG9 = new ProductXMarket(productG,9,138.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PH9 = new ProductXMarket(productH,9,388.15,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PJ9 = new ProductXMarket(productJ,9,158.89,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PK9 = new ProductXMarket(productK,9,56.19,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PM9 = new ProductXMarket(productM,9,839.8,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PO9 = new ProductXMarket(productO,9,968.95,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PP9 = new ProductXMarket(productP,9,124,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PQ9 = new ProductXMarket(productQ,9,59.47,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PR9 = new ProductXMarket(productR,9,803.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PS9 = new ProductXMarket(productS,9,267.5,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PT9 = new ProductXMarket(productT,9,249,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PU9 = new ProductXMarket(productU,9,296.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PW9 = new ProductXMarket(productW,9,97.52,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PY9 = new ProductXMarket(productY,9,35,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAB9 = new ProductXMarket(productAB,9,39.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAC9 = new ProductXMarket(productAC,9,65,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAD9 = new ProductXMarket(productAD,9,140,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAE9 = new ProductXMarket(productAE,9,160,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        
        ProductXMarket PA10 = new ProductXMarket(productA,10,175.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PC10 = new ProductXMarket(productC,10,136.91,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PD10 = new ProductXMarket(productD,10,291.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PE10 = new ProductXMarket(productE,10,100.49,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PF10 = new ProductXMarket(productF,10,53.19,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PG10 = new ProductXMarket(productG,10,135.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PH10 = new ProductXMarket(productH,10,385.15,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PI10 = new ProductXMarket(productI,10,290.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PJ10 = new ProductXMarket(productJ,10,155.89,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PK10 = new ProductXMarket(productK,10,53.19,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PM10 = new ProductXMarket(productM,10,836.8,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PN10 = new ProductXMarket(productN,10,426,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PO10 = new ProductXMarket(productO,10,965.95,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PP10 = new ProductXMarket(productP,10,121,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PQ10 = new ProductXMarket(productQ,10,56.47,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PR10 = new ProductXMarket(productR,10,800.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PS10 = new ProductXMarket(productS,10,264.5,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PT10 = new ProductXMarket(productT,10,246,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PU10 = new ProductXMarket(productU,10,293.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PW10 = new ProductXMarket(productW,10,94.52,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PY10 = new ProductXMarket(productY,10,32,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PZ10 = new ProductXMarket(productZ,10,252,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAB10 = new ProductXMarket(productAB,10,36.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAC10 = new ProductXMarket(productAC,10,62,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAD10 = new ProductXMarket(productAD,10,137,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAE10 = new ProductXMarket(productAE,10,157,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        
        ProductXMarket PA11 = new ProductXMarket(productA,11,181.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PC11 = new ProductXMarket(productC,11,142.91,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PD11 = new ProductXMarket(productD,11,297.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PE11 = new ProductXMarket(productE,11,105.49,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PF11 = new ProductXMarket(productF,11,59.19,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PG11 = new ProductXMarket(productG,11,141.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PH11 = new ProductXMarket(productH,11,391.15,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PJ11 = new ProductXMarket(productJ,11,161.89,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PK11 = new ProductXMarket(productK,11,59.19,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PM11 = new ProductXMarket(productM,11,842.8,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PO11 = new ProductXMarket(productO,11,971.95,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PP11 = new ProductXMarket(productP,11,127,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PQ11 = new ProductXMarket(productQ,11,62.47,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PR11 = new ProductXMarket(productR,11,806.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PS11 = new ProductXMarket(productS,11,280.5,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PT11 = new ProductXMarket(productT,11,252,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PU11 = new ProductXMarket(productU,11,299.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PW11 = new ProductXMarket(productW,11,100.52,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PY11 = new ProductXMarket(productY,11,38,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAB11 = new ProductXMarket(productAB,11,42.99,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAC11 = new ProductXMarket(productAC,11,68,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAD11 = new ProductXMarket(productAD,11,143,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket PAE11 = new ProductXMarket(productAE,11,163,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        
        ProductXMarket PA2 = new ProductXMarket(productA,2,178.99,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
		ProductXMarket PB2 = new ProductXMarket(productB,2,285,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PC2 = new ProductXMarket(productC,2,139.91,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PD2 = new ProductXMarket(productD,2,294.99,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PE2 = new ProductXMarket(productE,2,102.49,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PF2 = new ProductXMarket(productF,2,56.19,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PG2 = new ProductXMarket(productG,2,138.99,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PH2 = new ProductXMarket(productH,2,388.15,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PI2 = new ProductXMarket(productI,2,293.99,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PK2 = new ProductXMarket(productK,2,56.19,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PM2 = new ProductXMarket(productM,2,839.8,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PP2 = new ProductXMarket(productP,2,124,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PQ2 = new ProductXMarket(productQ,2,59.47,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PR2 = new ProductXMarket(productR,2,803.99,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PS2 = new ProductXMarket(productS,2,267.5,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PT2 = new ProductXMarket(productT,2,249,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PU2 = new ProductXMarket(productU,2,296.99,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PV2 = new ProductXMarket(productV,2,262,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        
        ProductXMarket PA12 = new ProductXMarket(productA,12,173.99,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
		ProductXMarket PB12 = new ProductXMarket(productB,12,285,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PC12 = new ProductXMarket(productC,12,134.91,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PD12 = new ProductXMarket(productD,12,289.99,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PF12 = new ProductXMarket(productF,12,51.19,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PG12 = new ProductXMarket(productG,12,133.99,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PH12 = new ProductXMarket(productH,12,383.15,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PK12 = new ProductXMarket(productK,12,51.19,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PM12 = new ProductXMarket(productM,12,834.8,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PP12 = new ProductXMarket(productP,12,119,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PQ12 = new ProductXMarket(productQ,12,54.47,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PR12 = new ProductXMarket(productR,12,798.99,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PS12 = new ProductXMarket(productS,12,262.5,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PT12 = new ProductXMarket(productT,12,244,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PU12 = new ProductXMarket(productU,12,291.99,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket PV12 = new ProductXMarket(productV,12,257,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        
        ProductXMarket PA3 = new ProductXMarket(productA,3,181.99,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PC3 = new ProductXMarket(productC,3,142.91,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PD3 = new ProductXMarket(productD,3,297.99,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PE3 = new ProductXMarket(productE,3,105.49,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PF3 = new ProductXMarket(productF,3,59.19,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PG3 = new ProductXMarket(productG,3,141.99,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PH3 = new ProductXMarket(productH,3,391.15,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PI3 = new ProductXMarket(productI,3,296.99,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PK3 = new ProductXMarket(productK,3,59.19,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PM3 = new ProductXMarket(productM,3,842.8,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PP3 = new ProductXMarket(productP,3,127,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PQ3 = new ProductXMarket(productQ,3,64.47,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PR3 = new ProductXMarket(productR,3,807.99,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PS3 = new ProductXMarket(productS,3,271.5,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PT3 = new ProductXMarket(productT,3,253,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PU3 = new ProductXMarket(productU,3,300.99,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PX3 = new ProductXMarket(productX,3,187,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PAA3 = new ProductXMarket(productAA,3,129.6,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PAF3 = new ProductXMarket(productAF,3,139,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        
        ProductXMarket PA13 = new ProductXMarket(productA,13,184.99,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PC13 = new ProductXMarket(productC,13,145.91,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PD13 = new ProductXMarket(productD,13,300.99,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PE13 = new ProductXMarket(productE,13,108.49,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PG13 = new ProductXMarket(productG,13,144.99,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PH13 = new ProductXMarket(productH,13,394.15,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PI13 = new ProductXMarket(productI,13,299.99,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PK13 = new ProductXMarket(productK,13,63.19,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PM13 = new ProductXMarket(productM,13,846.8,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PP13 = new ProductXMarket(productP,13,131,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PR13 = new ProductXMarket(productR,13,811.99,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PS13 = new ProductXMarket(productS,13,275.5,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PT13 = new ProductXMarket(productT,13,257,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PU13 = new ProductXMarket(productU,13,304.99,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PX13 = new ProductXMarket(productX,13,191,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PAA13 = new ProductXMarket(productAA,13,133.6,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);
        ProductXMarket PAF13 = new ProductXMarket(productAF,13,143,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);

        Market marketCoto1 = new Market(1,"Coto Abasto","https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", -34.602433, -58.411372, List.of(PA1,PC1,PD1, PE1, PF1, PG1, PH1, PI1, PJ1, PK1, PM1, PN1, PO1, PP1, PQ1, PR1, PS1, PT1, PU1, PW1, PY1, PZ1, PAB1,PAC1,PAD1,PAE1));
        Market marketCoto2 = new Market(4,"Coto Almagro I","https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", -34.608678, -58.431261, List.of(PA4, PC4, PD4, PE4, PF4, PG4, PH4, PJ4, PK4, PM4, PO4, PP4, PQ4, PR4, PS4, PT4, PU4, PW4, PY4, PAB4, PAC4, PAD4, PAE4));
        Market marketCoto3 = new Market(6,"Coto Almagro III","https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", -34.611945, -58.420879, List.of(PA6,PC6,PD6, PE6, PF6, PG6, PH6, PI6, PJ6, PK6, PM6, PN6, PO6, PP6, PQ6, PR6, PS6, PT6, PU6, PW6, PY6, PZ6, PAB6,PAC6,PAD6,PAE6));
        Market marketCoto4 = new Market(7,"Coto Balvanera I","https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", -34.616210, -58.398437, List.of(PA7, PC7, PD7, PE7, PF7, PG7, PH7, PJ7, PK7, PM7, PO7, PP7, PQ7, PR7, PS7, PT7, PU7, PW7, PY7, PAB7, PAC7, PAD7, PAE7));        
        Market marketCoto5 = new Market(8,"Coto Barracas","https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", -34.632911, -58.373958, List.of(PA8,PC8,PD8, PE8, PF8, PG8, PH8, PI8, PJ8, PK8, PM8, PN8, PO8, PP8, PQ8, PR8, PS8, PT8, PU8, PW8, PY8, PZ8, PAB8,PAC8,PAD8,PAE8));
        Market marketCoto6 = new Market(9,"Coto Barrio Norte I","https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", -34.597122, -58.405841, List.of(PA9, PC9, PD9, PE9, PF9, PG9, PH9, PJ9, PK9, PM9, PO9, PP9, PQ9, PR9, PS9, PT9, PU9, PW9, PY9, PAB9, PAC9, PAD9, PAE9));
        Market marketCoto7 = new Market(10,"Coto Belgrano I","https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", -34.571151, -58.458301, List.of(PA10,PC10,PD10, PE10, PF10, PG10, PH10, PI10, PJ10, PK10, PM10, PN10, PO10, PP10, PQ10, PR10, PS10, PT10, PU10, PW10, PY10, PZ10, PAB10,PAC10,PAD10,PAE10));
        Market marketCoto8 = new Market(11,"Coto Boedo","https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", -34.621707, -58.416465, List.of(PA11, PC11, PD11, PE11, PF11, PG11, PH11, PJ11, PK11, PM11, PO11, PP11, PQ11, PR11, PS11, PT11, PU11, PW11, PY11, PAB11, PAC11, PAD11, PAE11));
        Market marketDia1 = new Market(2,"Dia Caballito","http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", -34.608950, -58.441479, List.of(PA2,PB2,PC2,PD2,PE2,PF2,PG2,PH2,PI2,PK2,PM2,PP2,PQ2,PR2,PS2,PT2,PU2,PV2));
        Market marketDia2 = new Market(12,"Dia Almagro","http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", -34.611285, -58.420466, List.of(PA12,PB12,PC12,PD12,PF12,PG12,PH12,PK12,PM12,PP12,PQ12,PR12,PS12,PT12,PU12,PV12));
        Market marketCarrefour1 = new Market(3,"Carrefour Hipermercado","http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", -34.611108, -58.460818, List.of(PA3,PC3,PD3,PE3,PF3,PG3,PH3,PI3,PK3,PM3,PP3,PQ3,PR3,PS3,PT3,PU3,PX3,PAA3,PAF3));
        Market marketCarrefour2 = new Market(13,"Carrefour Express","http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", -34.581269, -58.449086, List.of(PA13,PC13,PD13,PE13,PG13,PH13,PI13,PK13,PM13,PP13,PR13,PS13,PT13,PU13,PX13,PAA13,PAF13));

        productList = List.of(PA1, PC1, PD1, PE1, PF1, PG1, PH1, PI1, PJ1,PK1,PM1,PN1,PO1,PP1,PQ1,PR1,PS1,PT1,PU1,PW1,PY1,PZ1,PAB1,PAC1, PAD1, PAE1, PA4,PC4,PD4,PE4,PF4,PG4,PH4,PJ4,PK4,PM4,PO4,PP4,PQ4,PR4,PS4,PT4,PU4,PW4,PY4,PAB4,PAC4, PAD4, PAE4, PA6,PC6,PD6,PE6,PF6,PG6,PH6,PI6,PJ6,PK6,PM6,PN6,PO6,PP6,PQ6,PR6,PS6,PT6,PU6,PW6,PY6,PZ6,PAB6,PAC6, PAD6, PAE6, PA7,PC7,PD7,PE7,PF7,PG7,PH7,PJ7,PK7,PM7,PO7,PP7,PQ7,PR7,PS7,PT7,PU7,PW7,PY7,PAB7,PAC7, PAD7, PAE7, PA8,PC8,PD8,PE8,PF8,PG8,PH8,PI8,PJ8,PK8,PM8,PN8,PO8,PP8,PQ8,PR8,PS8,PT8,PU8,PW8,PY8,PZ8,PAB8,PAC8, PAD8, PAE8, PA9,PC9,PD9,PE9,PF9,PG9,PH9,PJ9,PK9,PM9,PO9,PP9,PQ9,PR9,PS9,PT9,PU9,PW9,PY9,PAB9,PAC9, PAD9, PAE9, PA10,PC10,PD10,PE10,PF10, PG10,PH10,PI10,PJ10,PK10, PM10, PN10, PO10,PP10, PQ10, PR10,PS10, PT10, PU10,PW10, PY10, PZ10, PAB10,PAC10,PAD10,PAE10,PA11,PC11,PD11,PE11,PF11, PG11,PH11,PJ11,PK11, PM11, PO11,PP11, PQ11, PR11,PS11, PT11, PU11,PW11,PY11, PAB11,PAC11,PAD11,PAE11,PA2,PB2,PC2,PD2,PE2,PF2,PG2,PH2,PI2,PK2,PM2,PP2,PQ2,PR2,PS2,PT2,PU2,PV2,PA12, PC12, PD12, PF12, PG12, PH12, PK12, PM12, PP12, PQ12, PR12, PS12, PT12, PU12, PV12, PA3,PC3,PD3,PE3,PF3,PG3,PH3,PI3,PK3,PM3,PP3,PQ3,PR3,PS3,PT3,PU3,PX3,PAA3, PAF3, PA13, PC13, PD13, PE13, PG13, PH13, PI13, PK13, PM13, PP13, PR13, PS13, PT13, PU13, PX13, PAA13,PAF13);
        marketList = List.of(marketCoto1, marketCoto2, marketCoto3, marketCoto4, marketCoto5, marketCoto6, marketCoto7, marketCoto8, marketDia1, marketDia2, marketCarrefour1, marketCarrefour2);
    }

    @Override
    public List<ProductXMarket> getAllProducts(String productName, double lat, double lon, double maxDistance)
    {
        if(productName == null)
        {
            return productList;
        }
        List<Long> closeMarkets = marketList.stream().filter(m -> m.getDistance(lat, lon) <= maxDistance).map(Market::getId).collect(Collectors.toList());
        return productList.stream().filter(p ->
                        p.getProduct().getName().toUpperCase().contains(productName.toUpperCase())
                                || p.getProduct().getBarcode().toUpperCase().contains(productName.toUpperCase()))
                .filter(p -> closeMarkets.contains(p.getIdMarket())).collect(Collectors.toList());

    }

    @Override
    public List<ProductXMarket> getProduct(long idProduct, double lat, double lon, double maxDistance)
    {
        List<ProductXMarket> productXMarketsList = productList.stream().filter(p -> p.getProduct().getId() == idProduct
                && marketList.stream().filter(m -> m.getId() == p.getIdMarket()).collect(Collectors.toList()).get(0).getDistance(lat, lon) <= maxDistance)
                .collect(Collectors.toList());

        productXMarketsList.forEach(p -> p.setDistance(marketList.stream().filter(m -> m.getId() == p.getIdMarket()).collect(Collectors.toList()).get(0).getDistance(lat, lon)));

        return productXMarketsList;
    }

    @Override
    public List<ProductXMarket> getProducts(List<Long> idProductList)
    {
        return productList.stream().filter(p -> idProductList.contains(p.getProduct().getId())).collect(Collectors.toList());
    }

}
