package a12;
/*
*@date 20080621
*@author guiws
*/

/* Submenus, check box menu items, swapping menus,
 mnemonics (shortcuts) and action commands.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ManagementMenu extends JFrame {
	JTextArea theArea = null;
	JDesktopPane deskPane;
	JMenuBar MBar;

	public ManagementMenu() {
		super("区域疾病监控管理");
		MBar = new JMenuBar();
		JbuildFileMenu();
		MBar.add(theM);
		MBar.add(theC);
		MBar.add(theS);
		setJMenuBar(MBar);
		deskPane = new JDesktopPane();
		add(deskPane);
		setBounds(0, 0, 700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);

		addItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				creatPAddFrame();
			}
		});
		modifyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				creatPInfoTbFrame();
			}
		});

		saleInputItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				creatSaleInputFrame();
			}
		});

		wholeSaleItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				creatSaleStatBySalerFrame();
			}
		});

		salePositionItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				creatSalePositionFrame();
			}
		});

	}

	private void creatPAddFrame() {
		JInternalFrame PAddIframe = new ProductInput().getIFrame();
		deskPane.add(PAddIframe);
		deskPane.setSelectedFrame(PAddIframe);
	}

	private void creatPInfoTbFrame() {
		JInternalFrame PInfoTbIframe = new ProductInfoJTable("产品信息").getIFrame();
		deskPane.add(PInfoTbIframe);
		deskPane.setSelectedFrame(PInfoTbIframe);
	}

	private void creatPDownShelfFrame() {
		JInternalFrame PDownShelfIframe = new PDownShelfMgmt(PDownShelfMgmt.windowTitle).getIFrame();
		deskPane.add(PDownShelfIframe);
		deskPane.setSelectedFrame(PDownShelfIframe);
	}

	private void creatSaleInputFrame() {
		JInternalFrame saleInputIframe = new SaleInput().getIFrame();
		deskPane.add(saleInputIframe);
		deskPane.setSelectedFrame(saleInputIframe);
	}

	private void creatSaleStatBySalerFrame() {
		JInternalFrame saleStatBySalerIframe = new SaleStatBySaler("销售人员统计信息").getIFrame();
		deskPane.add(saleStatBySalerIframe);
		deskPane.setSelectedFrame(saleStatBySalerIframe);
	}

	private void creatSalePositionFrame() {
		JInternalFrame salePositionIframe = new SalePosition("销售排名信息").getIFrame();
		deskPane.add(salePositionIframe);
		deskPane.setSelectedFrame(salePositionIframe);
	}

	private void creatChatToolFrame() {
		JInternalFrame ChatToolIframe = new SetChatTool().getIFrame();
		deskPane.add(ChatToolIframe);
		deskPane.setSelectedFrame(ChatToolIframe);
	}

	MyMenu theM, theC, theS, theD;
	JMenuItem addItem, modifyItem, commentItem, downShelfItem, outOfStockItem, PTypeItem;
	JMenuItem addOrderItem, OrderChangeItem, userPointItem;
	JMenuItem wholeSaleItem, salePositionItem, accessPositionItem, memberSpenseItem, saleInputItem;
	JMenuItem excluShopInfoItem, payTypeItem, sendTypeItem, chatItem, votingOnLineItem;

	public void JbuildFileMenu() {
		theM = new MyMenu("医院等相关部门管理");
		addItem = theM.addItem("信息录入");
		modifyItem = theM.addItem("修改信息");

		theC = new MyMenu("病人信息管理");
		addOrderItem = theC.addItem("信息录入");
		saleInputItem = theC.addItem("修改信息");

		theS = new MyMenu("监控管理");
		wholeSaleItem = theS.addItem("疾病统计");
		salePositionItem = theS.addItem("患病排名");
		wholeSaleItem = theS.addItem("区域统计");
		accessPositionItem = theS.addItem("区域排名");

	}

	public class MyMenu extends JMenu {
		MyMenu(String menuName) {
			this.setText(menuName);
		}

		public JMenuItem addItem(String itemName) {
			return this.add(new JMenuItem(itemName));
		}

		public JMenuItem getitem(int itemPosition) {
			return getItem(itemPosition);
		}
	}

	public static void main(String[] args) {
		/*
		 * try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		 * 
		 * } catch (Exception e) {
		 * 
		 * }
		 */
		JFrame F = new ManagementMenu();
	}
}
