package isp.lab9.exercise1.ui;

import isp.lab9.exercise1.services.StockItem;
import isp.lab9.exercise1.services.StockMarketQueryService;
import isp.lab9.exercise1.services.UserPortfolio;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.Map;

/**
 * todo: implement - it should look similar to the 'Buy' panel
 */
public class SellJPanel extends JPanel {
    private final UserPortfolio portfolio;
    private final StockMarketQueryService marketService;

    public SellJPanel(StockMarketJFrame mainFrame) {
        this.portfolio = mainFrame.getPortfolio();
        this.marketService = mainFrame.getMarketService();

        this.setLayout(new GridLayout(6, 2));

        JLabel fundsLabel = new JLabel("Available funds:");
        JTextField fundsField = new JTextField();
        fundsField.setEditable(false);

        JLabel symbolLabel = new JLabel("Symbol:");
        JComboBox<String> symbolCombo = new JComboBox<>(portfolio.getShares().keySet().toArray(new String[0]));

        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityField = new JTextField();

        JLabel totalLabel = new JLabel("Total gain:");
        JTextField totalField = new JTextField();
        totalField.setEditable(false);

        JButton calcButton = new JButton("Get gain");
        JButton sellButton = new JButton("Sell");

        this.add(fundsLabel);
        this.add(fundsField);

        this.add(symbolLabel);
        this.add(symbolCombo);

        this.add(quantityLabel);
        this.add(quantityField);

        this.add(totalLabel);
        this.add(totalField);

        this.add(calcButton);
        this.add(sellButton);

        JLabel msgLabel = new JLabel("");
        this.add(msgLabel);

        // setează fondurile inițiale
        fundsField.setText(portfolio.getCash() + " $");

        // buton de calcul câștig
        calcButton.addActionListener(e -> {
            try {
                String symbol = (String) symbolCombo.getSelectedItem();
                int qty = Integer.parseInt(quantityField.getText());
                StockItem item = marketService.getStock(symbol);
                if (item != null && qty > 0) {
                    BigDecimal gain = item.getPrice().multiply(BigDecimal.valueOf(qty));
                    totalField.setText(gain + " $");
                } else {
                    totalField.setText("Invalid");
                }
            } catch (Exception ex) {
                totalField.setText("Error");
            }
        });

        // buton de vânzare
        sellButton.addActionListener(e -> {
            try {
                String symbol = (String) symbolCombo.getSelectedItem();
                int qtyToSell = Integer.parseInt(quantityField.getText());
                Map<String, Integer> shares = portfolio.getShares();
                int ownedQty = shares.getOrDefault(symbol, 0);

                if (qtyToSell <= 0 || qtyToSell > ownedQty) {
                    msgLabel.setText("Invalid quantity.");
                    return;
                }

                StockItem item = marketService.getStock(symbol);
                BigDecimal totalGain = item.getPrice().multiply(BigDecimal.valueOf(qtyToSell));
                shares.put(symbol, ownedQty - qtyToSell);
                portfolio.setCash(portfolio.getCash().add(totalGain));

                fundsField.setText(portfolio.getCash() + " $");
                msgLabel.setText("Sold " + qtyToSell + " shares.");

            } catch (Exception ex) {
                msgLabel.setText("Error during sale.");
            }
        });
    }
}
