package isp.lab9.exercise1.ui;

import isp.lab9.exercise1.services.StockItem;
import isp.lab9.exercise1.services.StockMarketQueryService;
import isp.lab9.exercise1.services.UserPortfolio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

/**
 *  todo: implement portfolio panel; for each owned stock add symbol, quantity, price per unit, total price of the position
 *  it should look similar to the 'Market' panel
 */
public class PortfolioJPanel extends JPanel {
    public PortfolioJPanel(StockMarketJFrame mainFrame) {
        UserPortfolio portfolio = mainFrame.getPortfolio();
        StockMarketQueryService service = mainFrame.getMarketService();

        String[] columnNames = {"Symbol", "Quantity", "Price", "Total"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);

        Map<String, Integer> owned = portfolio.getShares();
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(owned.entrySet());

        for (int i = 0; i < entries.size(); i++) {
            String symbol = entries.get(i).getKey();
            int qty = entries.get(i).getValue();
            StockItem stock = service.getStock(symbol);
            if (stock != null) {
                BigDecimal price = stock.getPrice();
                BigDecimal total = price.multiply(BigDecimal.valueOf(qty));
                model.addRow(new Object[]{symbol, qty, price, total});
            }
        }

        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(table), BorderLayout.CENTER);

        JLabel cashLabel = new JLabel("Available cash: " + portfolio.getCash() + " USD");
        cashLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(cashLabel, BorderLayout.SOUTH);
    }
}
