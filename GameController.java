import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Dimension;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GameController implements ActionListener {
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// No longer need these
	// I directly stored runners and pieces on to playerTrackers and runnerTrackers
	// playerTrackers for players
	public static ArrayList<Shape> playerTracker1;
	public static ArrayList<Shape> playerTracker2;
	public static ArrayList<Shape> playerTracker3;
	public static ArrayList<Shape> playerTracker4;

	// Tracking the runners
	public static ArrayList<Runner> runnerTracker1;
	public static ArrayList<Runner> runnerTracker2;
	public static ArrayList<Runner> runnerTracker3;
	public static ArrayList<Runner> runnerTracker4;

	// But have to edit save game to compile without these
	////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static ArrayList<ArrayList<Shape>> playerTrackers = new ArrayList<ArrayList<Shape>>();
	private ArrayList<ArrayList<Runner>> runnerTrackers = new ArrayList<ArrayList<Runner>>();

	private ArrayList<Integer> diceValues;
	private ArrayList<Dice> diceTrackers;
	private Board demo;

	private int diceSum;

	private HashMap<Integer, Integer> startingRowForColumn;

	ArrayList<UserColumn> columnsList;

	private int curPlayerNum;
	private ArrayList<ArrayList<UserColumn>> claimedColumns;

	public GameController(Board demo) {
		this.demo = demo;

		startingRowForColumn = new HashMap<Integer, Integer>();
		startingRowForColumn.put(2, 7);
		startingRowForColumn.put(3, 8);
		startingRowForColumn.put(4, 9);
		startingRowForColumn.put(5, 10);
		startingRowForColumn.put(6, 11);
		startingRowForColumn.put(7, 12);
		startingRowForColumn.put(8, 11);
		startingRowForColumn.put(9, 10);
		startingRowForColumn.put(10, 9);
		startingRowForColumn.put(11, 8);
		startingRowForColumn.put(12, 7);

		for (int i = 0; i < demo.getNoOfPlayers(); i++) {
			playerTrackers.add(new ArrayList<Shape>());
			runnerTrackers.add(new ArrayList<Runner>());
		}

		diceValues = new ArrayList<Integer>();
		setActionListener();

		diceTrackers = new ArrayList<Dice>();

		columnsList = new ArrayList<UserColumn>();
		columnsList.add(null);
		columnsList.add(null);
		for (int i = 2; i < 13; i++) {
			columnsList.add(new UserColumn(i, getGrid()));
		}
		columnsList.get(2).setTopRow(5);
		columnsList.get(3).setTopRow(4);
		columnsList.get(4).setTopRow(3);
		columnsList.get(5).setTopRow(2);
		columnsList.get(6).setTopRow(1);
		columnsList.get(7).setTopRow(0);
		columnsList.get(8).setTopRow(1);
		columnsList.get(9).setTopRow(2);
		columnsList.get(10).setTopRow(3);
		columnsList.get(11).setTopRow(4);
		columnsList.get(12).setTopRow(5);
		curPlayerNum = 1;
		claimedColumns = new ArrayList<ArrayList<UserColumn>>();
		for (int i = 0; i < demo.getNoOfPlayers(); i++) {
			claimedColumns.add(new ArrayList<UserColumn>());
		}

	}

	public Dice getDice1() {
		return demo.getDice1();
	}

	public Dice getDice2() {
		return demo.getDice2();
	}

	public Dice getDice3() {
		return demo.getDice3();
	}

	public Dice getDice4() {
		return demo.getDice4();
	}

	public int getDice1Value() {
		return demo.getDice1Value();
	}

	public int getDice2Value() {
		return demo.getDice2Value();
	}

	public int getDice3Value() {
		return demo.getDice3Value();
	}

	public int getDice4Value() {
		return demo.getDice4Value();
	}

	public Square getSquareFromGrid(int x, int y) {
		return demo.getSquareFromGrid(x, y);
	}

	public Grid getGrid() {
		return demo.getGrid();
	}

	public Square[][] getGridSquares() {
		return getGrid().getGridSquares();
	}

	public void setActionListener() {
		getDice1().addActionListener(this);
		getDice2().addActionListener(this);
		getDice3().addActionListener(this);
		getDice4().addActionListener(this);
		getFinishTurnButton().addActionListener(this);
		getRollDiceButton().addActionListener(this);
	}

	public int getDiceSum(ArrayList<Integer> diceValues) {
		return diceValues.stream().mapToInt(f -> f.intValue()).sum();
	}

	public void placeRunner() {
		diceSum = getDiceSum(diceValues);
		Runner runner = new Runner();
		runner.moveTo(getSquareFromGrid(startingRowForColumn.get(diceSum), diceSum - 1));
		runner.setCurColumn(columnsList.get(diceSum));
		runnerTrackers.get(curPlayerNum - 1).add(runner);
		columnsList.get(diceSum).setRunnerRow(startingRowForColumn.get(diceSum));
	}

	public void placeRunnerOnSpecificSquare(Square sq) {
		diceSum = getDiceSum(diceValues);
		Runner runner = new Runner();
		runner.setCurColumn(columnsList.get(diceSum));
		runner.moveTo(sq);
		runnerTrackers.get(curPlayerNum - 1).add(runner);
		columnsList.get(diceSum).setRunnerRow(sq.getXcoord());
	}

	public void moveRunner(Runner runner, int rowNum) {
		diceSum = getDiceSum(diceValues);
		runner.moveTo(getSquareFromGrid(rowNum, diceSum - 1));
		columnsList.get(diceSum).setRunnerRow(rowNum);
	}

	public Boolean checkColumnForRunner(int colNumForPlayer) {
		if (columnsList.get(colNumForPlayer).getRunnerRow() >= 0) {
			return true;
		}
		return false;
	}

	public int findRunnerPosition(int colNumForPlayer) {
		return columnsList.get(colNumForPlayer).getRunnerRow();
	}

	public JButton getFinishTurnButton() {
		return demo.getFinishTurnButton();
	}

	public JButton getRollDiceButton() {
		return demo.getRollDiceButton();
	}

	public Square removeRunnerFromBoard(Runner runner) {
		Square runnerSquare = runner.getCurSquare();
		runnerSquare.revalidate();
		runnerSquare.repaint();
		runnerSquare.remove(runner);
		// runnerSquare.setContainsRunner(false);
		runnerSquare.setRunnerOnSquare(null);
		columnsList.get(runner.getYcoord() + 1).setRunnerRow(-1);
		return runnerSquare;
	}

	public void replaceRunnersWithPieces(int playerNum) {
		for (Runner runner : runnerTrackers.get(playerNum - 1)) {
			removeRunnerFromBoard(runner);
			if (runner.getCurColumn()
					.getShapeRow(new Shape((String) playerOptions.finalValues.get(curPlayerNum - 1).get(2))) >= 0) {
				for (int i = 0; i < playerTrackers.get(playerNum - 1).size(); i++) {
					if (playerTrackers.get(playerNum - 1).get(i).getYcoord() == runner.getYcoord()) {
						playerTrackers.get(playerNum - 1).get(i).moveTo(runner.getCurSquare());
						playerTrackers.get(playerNum - 1).get(i).getCurColumn().setShapeRow(
								new Shape((String) playerOptions.finalValues.get(curPlayerNum - 1).get(2)),
								runner.getXcoord());
					}
				}
			} else {
				String shapeString = (String) playerOptions.finalValues.get(playerNum - 1).get(2);
				Shape playerShape = new Shape(shapeString);
				playerShape.moveTo(runner.getCurSquare());
				playerShape.setCurColumn(columnsList.get(runner.getYcoord() + 1));
				playerShape.getCurColumn().setShapeRow(playerShape, runner.getXcoord());
				playerTrackers.get(playerNum - 1).add(playerShape);
			}
			if (runner.getXcoord() == columnsList.get(runner.getYcoord() + 1).getTopRow()) {
				claimingColumn(runner.getYcoord() + 1);
			}
		}
		runnerTrackers.set(playerNum - 1, new ArrayList<Runner>());
	}

	public void removePiece(Shape piece) {
		Square sq = piece.getCurSquare();
		sq.revalidate();
		sq.repaint();
		sq.remove(piece);
		piece.getCurColumn().setShapeRow(piece, -1);
	}

	public void goingBust(int playerNum) {
		for (Runner runner : runnerTrackers.get(playerNum - 1)) {
			removeRunnerFromBoard(runner);
		}
		runnerTrackers.set(playerNum - 1, new ArrayList<Runner>());
	}

	public Boolean checkingColumnForShape(Shape shape, int colNumAccordingToPlayer) {
		if (columnsList.get(colNumAccordingToPlayer).getShapeRow(shape) >= 0) {
			return true;
		}
		;
		return false;
	}

	public int findingRowOfShapeonColumn(Shape shape, int colNumAccordingToPlayer) {
		return columnsList.get(colNumAccordingToPlayer).getShapeRow(shape);
	}

	public int aRunnerOnSameRowAsShape(int playerNum) {
		for (Runner runner : runnerTrackers.get(curPlayerNum - 1)) {
			if (runner.getCurColumn()
					.getShapeRow(new Shape((String) playerOptions.finalValues.get(curPlayerNum - 1).get(2))) >= 0) {
				return 1;
			}
		}
		return 0;
	}

	public void claimingColumn(int colNumAccordingToPlayer) {
		columnsList.get(colNumAccordingToPlayer).claimColumn();
		for (int i = 0; i < demo.getNoOfPlayers(); i++) {
			if (((i + 1) != curPlayerNum)) {
				int noOfPieces = playerTrackers.get(i).size();
				for (int j = 0; j < noOfPieces; j++) {
					if (playerTrackers.get(i).get(j).getYcoord() + 1 == colNumAccordingToPlayer) {
						Shape piece = playerTrackers.get(i).get(j);
						removePiece(piece);
						playerTrackers.get(i).remove(j);
						break;
					}
				}
			}
		}
		claimedColumns.get(curPlayerNum - 1).add(columnsList.get(colNumAccordingToPlayer));
	}

	public void aiMoveHard() {

		hardAi ai = new hardAi();
		ai.selectColumn(getDice4(), getDice3(), getDice2(), getDice1());

		System.out.println(ai.combinationSum.get(0));

		for (int i = 0; i < ai.combinationSum.size(); i++) {
			try {

				diceSum = ai.combinationSum.get(i);
				if (ai.combinationSum.size() > 0) {

					if (columnsList.get(ai.combinationSum.get(i)).getClaimedVal()) {
						System.out.println("Claimed column");
					} else {
						int column = ai.combinationSum.get(i);
						if (checkColumnForRunner(diceSum)) {
							int runnerPos = findRunnerPosition(diceSum);
							if (runnerPos - 1 < columnsList.get(diceSum).getTopRow()) {

							} else {
								moveRunner(getSquareFromGrid(runnerPos, column).getRunnerOnSquare(), runnerPos - 1);
								demo.getRollDicePanel().setMoveMade(true);
								try {
									wait(5);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block

								}
							}
						} else {
							if (runnerTrackers.get(curPlayerNum - 1).size() < 3) {
								if (!checkingColumnForShape(
										new Shape((String) playerOptions.finalValues.get(curPlayerNum - 1).get(2)),
										diceSum)) {
									if (playerTrackers.get(curPlayerNum - 1).size()
											+ runnerTrackers.get(curPlayerNum - 1).size()
											- aRunnerOnSameRowAsShape(curPlayerNum) < 3) {
										Runner runner = new Runner();
										runner.moveTo(
												getSquareFromGrid(startingRowForColumn.get(diceSum), diceSum - 1));
										runner.setCurColumn(columnsList.get(diceSum));
										runnerTrackers.get(curPlayerNum - 1).add(runner);
										columnsList.get(diceSum).setRunnerRow(startingRowForColumn.get(diceSum));
										demo.getRollDicePanel().setMoveMade(true);
									}

									else {
									}
								} else {
									int piecePos = findingRowOfShapeonColumn(
											new Shape((String) playerOptions.finalValues.get(curPlayerNum - 1).get(2)),
											diceSum);

									Runner runner = new Runner();
									runner.setCurColumn(columnsList.get(diceSum));
									runner.moveTo(getSquareFromGrid(piecePos - 1, diceSum - 1));
									runnerTrackers.get(curPlayerNum - 1).add(runner);
									columnsList.get(diceSum)
											.setRunnerRow(getSquareFromGrid(piecePos - 1, diceSum - 1).getXcoord());
									demo.getRollDicePanel().setMoveMade(true);
								}
							} else {
								System.out.println("Discarded Move");
							}
						}
					}
					diceValues = new ArrayList<Integer>();
					diceTrackers = new ArrayList<Dice>();

				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	public void aiMoveEasy() {
		easyAi ai = new easyAi();
		ai.selectColumn(getDice4(), getDice3(), getDice2(), getDice1());

		System.out.println(ai.combinationSum.get(0));

		for (int i = 0; i < ai.combinationSum.size(); i++) {
			try {

				diceSum = ai.combinationSum.get(i);
				if (ai.combinationSum.size() > 0) {

					if (columnsList.get(ai.combinationSum.get(i)).getClaimedVal()) {
						System.out.println("Claimed column");
					} else {
						int column = ai.combinationSum.get(i);
						if (checkColumnForRunner(diceSum)) {
							int runnerPos = findRunnerPosition(diceSum);
							if (runnerPos - 1 < columnsList.get(diceSum).getTopRow()) {

							} else {
								moveRunner(getSquareFromGrid(runnerPos, column).getRunnerOnSquare(), runnerPos - 1);
								demo.getRollDicePanel().setMoveMade(true);
								try {
									wait(5);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block

								}
							}
						} else {
							if (runnerTrackers.get(curPlayerNum - 1).size() < 3) {
								if (!checkingColumnForShape(
										new Shape((String) playerOptions.finalValues.get(curPlayerNum - 1).get(2)),
										diceSum)) {
									if (playerTrackers.get(curPlayerNum - 1).size()
											+ runnerTrackers.get(curPlayerNum - 1).size()
											- aRunnerOnSameRowAsShape(curPlayerNum) < 3) {
										Runner runner = new Runner();
										runner.moveTo(
												getSquareFromGrid(startingRowForColumn.get(diceSum), diceSum - 1));
										runner.setCurColumn(columnsList.get(diceSum));
										runnerTrackers.get(curPlayerNum - 1).add(runner);
										columnsList.get(diceSum).setRunnerRow(startingRowForColumn.get(diceSum));
										demo.getRollDicePanel().setMoveMade(true);
									}

									else {
									}
								} else {
									int piecePos = findingRowOfShapeonColumn(
											new Shape((String) playerOptions.finalValues.get(curPlayerNum - 1).get(2)),
											diceSum);

									Runner runner = new Runner();
									runner.setCurColumn(columnsList.get(diceSum));
									runner.moveTo(getSquareFromGrid(piecePos - 1, diceSum - 1));
									runnerTrackers.get(curPlayerNum - 1).add(runner);
									columnsList.get(diceSum)
											.setRunnerRow(getSquareFromGrid(piecePos - 1, diceSum - 1).getXcoord());
									demo.getRollDicePanel().setMoveMade(true);
								}
							} else {
								System.out.println("Discarded Move");
							}
						}
					}
					diceValues = new ArrayList<Integer>();
					diceTrackers = new ArrayList<Dice>();

				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent aevt) {
		Object selectedButton = aevt.getSource();
		if (selectedButton instanceof Dice) {
			if (!(((Dice) selectedButton).getSelected())) {
				((Dice) selectedButton).setSelectedImage(((Dice) selectedButton).getValue());
				diceValues.add(((Dice) selectedButton).getValue());
				diceTrackers.add(((Dice) selectedButton));
			}

			if (diceValues.size() == 2) {
				diceSum = getDiceSum(diceValues);
				if (columnsList.get(diceSum).getClaimedVal()) {
					System.out.println("Claimed column");
					for (Dice dice : diceTrackers) {
						dice.unselectDice();
					}
				} else {
					int column = diceSum - 1;
					if (checkColumnForRunner(diceSum)) {
						int runnerPos = findRunnerPosition(diceSum);
						if (runnerPos - 1 < columnsList.get(diceSum).getTopRow()) {
							for (Dice dice : diceTrackers) {
								dice.unselectDice();
							}
						} else {
							moveRunner(getSquareFromGrid(runnerPos, column).getRunnerOnSquare(), runnerPos - 1);
							demo.getRollDicePanel().setMoveMade(true);
						}
					} else {
						if (runnerTrackers.get(curPlayerNum - 1).size() < 3) {
							if (!checkingColumnForShape(
									new Shape((String) playerOptions.finalValues.get(curPlayerNum - 1).get(2)),
									diceSum)) {
								if (playerTrackers.get(curPlayerNum - 1).size()
										+ runnerTrackers.get(curPlayerNum - 1).size()
										- aRunnerOnSameRowAsShape(curPlayerNum) < 3) {
									placeRunner();
									demo.getRollDicePanel().setMoveMade(true);
								}

								else {
									for (Dice dice : diceTrackers) {
										dice.unselectDice();
									}
								}
							} else {
								int piecePos = findingRowOfShapeonColumn(
										new Shape((String) playerOptions.finalValues.get(curPlayerNum - 1).get(2)),
										diceSum);
								placeRunnerOnSpecificSquare(getSquareFromGrid(piecePos - 1, diceSum - 1));
								demo.getRollDicePanel().setMoveMade(true);
							}
						} else {
							System.out.println("Invalid Move");
							for (Dice dice : diceTrackers) {
								dice.unselectDice();
							}
						}
					}
				}
				diceValues = new ArrayList<Integer>();
				diceTrackers = new ArrayList<Dice>();
			}
		}

		else if (selectedButton.equals(getFinishTurnButton())) {

			if (demo.getRollDicePanel().getMoveMade()) {
				replaceRunnersWithPieces(curPlayerNum);
				if (claimedColumns.get(curPlayerNum - 1).size() == 3) {
					System.out.println("WINNER: Player " + Integer.toString(curPlayerNum));
					try {
						String shapeName = (String) playerOptions.finalValues.get(curPlayerNum - 1).get(2);
						String fileName = "ShapeImages/";
						if (shapeName.equals("Diamond")) {
							fileName += "GreenDiamond.png";
						} else if (shapeName.equals("Circle")) {
							fileName += "RedCircle.png";
						} else if (shapeName.equals("Star")) {
							fileName += "OrangeStar.png"; ////////////////////////// NEW
															////////////////////////// CODE////////////////////////////////
						} else if (shapeName.equals("Square")) {
							fileName += "BlueSquare.png";
						} else if (shapeName.equals("Runner")) {
							fileName += "Runner.png";
						}
						Image pieceImage = ImageIO.read(getClass().getResource(fileName));
						Image pieceImageNew = pieceImage.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
						ImageIcon playerPieceIcon = new ImageIcon(pieceImageNew);
						JOptionPane.showMessageDialog(new JFrame(), "WINNER: Player " + Integer.toString(curPlayerNum),
								"Game Over", JOptionPane.INFORMATION_MESSAGE, playerPieceIcon);
					} catch (Exception ex) {
						System.out.println(ex);
						JOptionPane.showMessageDialog(new JFrame(), "WINNER: Player " + Integer.toString(curPlayerNum),
								"Game Over", JOptionPane.INFORMATION_MESSAGE);
					}
					demo.dispose();
				}
			} else {
				System.out.println("Going bust");

				goingBust(curPlayerNum);

			}
			demo.getRollDicePanel().rollAll4Dice();
			System.out.println("curPlayerNum before changing player: " + Integer.toString(curPlayerNum));
			curPlayerNum = (curPlayerNum + 1) % demo.getNoOfPlayers();
			if (curPlayerNum == 0) {
				curPlayerNum = demo.getNoOfPlayers();
			}
			demo.getRollDicePanel().setMoveMade(false);
			System.out.println("curPlayerNum after finishing move: " + Integer.toString(curPlayerNum));

			demo.getRollDicePanel().rollAll4Dice();

			demo.getRollDicePanel().updatingPlayerMove();

			if (playerOptions.finalValues.get(curPlayerNum - 1).get(0).toString().replace("[", "").strip()
					.equals("Yes")) {

				if (playerOptions.finalValues.get(curPlayerNum - 1).get(3).toString().replace("]", "").strip()
						.equals("Easy")) {
					System.out.println("I am an EasyAI");
					aiMoveEasy();
				} else {
					System.out.println("I am an HardAI");
					aiMoveHard();
				}

				try {
					wait(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				getFinishTurnButton().doClick();
			}

		}

		else if (selectedButton.equals(getRollDiceButton())) {
			System.out.println("curPlayerNum: " + Integer.toString(curPlayerNum));
			if (!demo.getRollDicePanel().getMoveMade()) {
				System.out.println("Going bust");

				goingBust(curPlayerNum);
				demo.getRollDicePanel().updatingPlayerMove();
				curPlayerNum = (curPlayerNum + 1) % demo.getNoOfPlayers();
				if (curPlayerNum == 0) {
					curPlayerNum = demo.getNoOfPlayers();
				}
			}
			demo.getRollDicePanel().rollAll4Dice();
			demo.getRollDicePanel().setMoveMade(false);

			if (playerOptions.finalValues.get(curPlayerNum - 1).get(0).toString().replace("[", "").strip()
					.equals("Yes")) {

				if (playerOptions.finalValues.get(curPlayerNum - 1).get(3).toString().replace("]", "").strip()
						.equals("Easy")) {
					System.out.println("I am an EasyAI");
					aiMoveEasy();
				} else {
					System.out.println("I am an HardAI");
					aiMoveHard();
				}

				try {
					wait(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				getFinishTurnButton().doClick();
			}
		}
	}
}