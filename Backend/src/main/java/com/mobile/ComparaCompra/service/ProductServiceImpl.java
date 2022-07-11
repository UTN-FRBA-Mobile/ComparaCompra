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
        

        Market marketCoto1 = new Market(1,"Coto Abasto","https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", -34.602433, -58.411372, List.of(PA1,PC1,PD1, PE1, PF1, PG1, PH1, PI1, PJ1, PK1, PM1, PN1, PO1, PP1, PQ1, PR1, PS1, PT1, PU1, PW1, PY1, PZ1, PAB1,PAC1,PAD1,PAE1));
        Market marketDia1 = new Market(2,"Dia Caballito","http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", -34.608950, -58.441479, List.of(PA2,PB2,PC2,PD2,PE2,PF2,PG2,PH2,PI2,PK2,PM2,PP2,PQ2,PR2,PS2,PT2,PU2,PV2));
        Market marketCarrefour1 = new Market(3,"Carrefour Hipermercado","http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", -34.611108, -58.460818, List.of(PA3,PC3,PD3,PE3,PF3,PG3,PH3,PI3,PK3,PM3,PP3,PQ3,PR3,PS3,PT3,PU3,PX3,PAA3,PAF3));
        
        productList = List.of(PA1, PC1, PD1, PE1, PF1, PG1, PH1, PI1, PJ1,PK1,PM1,PN1,PO1,PP1,PQ1,PR1,PS1,PT1,PU1,PW1,PY1,PZ1,PAB1,PAC1, PAD1, PAE1, PA2,PB2,PC2,PD2,PE2,PF2,PG2,PH2,PI2,PK2,PM2,PP2,PQ2,PR2,PS2,PT2,PU2,PV2,PA3,PC3,PD3,PE3,PF3,PG3,PH3,PI3,PK3,PM3,PP3,PQ3,PR3,PS3,PT3,PU3,PX3,PAA3, PAF3);
        marketList = List.of(marketCoto1, marketDia1, marketCarrefour1);
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
