// Подключаем библиотеки
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class prog {
	public static void main(String[] args) {
		// Создаем объект окна
		okno nf = new okno();
	}
}

// Создаем класс окна, наследуется от класса JFrame
class okno extends JFrame {
	// Текстовое поле для результата
	private JTextArea text;
	// Две переменные для хранения двух введенных чисел
	private double p1 = 0, p2 = 0;
	// Тип операции, выбранной пользователем
	private int oper = 0;

	// Метод для обработки нажатия клавиш
	private void btnClick(JButton btn) {
		        // Определяем название нажатой кнопки
				String str = btn.getText();
				// Если нажата кнопка Выход - 
				// завершаем работу приложения
				if (str=="Выход") System.exit(0);
				// Если нажата кнопка очистить поле
				else if (str=="C")
				{
					// Очищаем поле - выводом в него 
					// пустой строки
				   	text.setText("");
				   	// Обнуляем переменные
				   	p1=p2=0;
				}
				// Если нажата кнопка Равно - вычисляем 
				else if (str=="=")
				{
				   // Перевод из строкового типа в целое число 
				   p2 = Integer.parseInt(text.getText());
				   // В зависимости какая была ранее выбрана
				   // операция - производим вычисление
				   if (oper==1) text.setText(""+(p1+p2));
				   if (oper==2) text.setText(""+(p1-p2));
				   if (oper==3) text.setText(""+(p1*p2));
				   if (oper==4) text.setText(""+(p1/p2));		  		   
				}
				// Если нажата кнопка Плюс
				else if (str=="+")
				{
					// Устанавливаем значение переменной oper
					// - которая отвечает за вид выбранной 
					// арифметической операции
					oper = 1;
					// Переводим из строкового типа в числовой 
				    p1 = Double.parseDouble(text.getText());
				    // Очищаем поле
				    text.setText("");			
				}
				// Если нажата кнопка Минус		
				else if (str=="-")
				{
					oper = 2;
				    p1 = Double.parseDouble(text.getText());
				    text.setText("");			
				}		
				// Если нажата кнопка Умножить		
				else if (str=="*")
				{
					oper = 3;
				    p1 = Double.parseDouble(text.getText());
				    text.setText("");			
				}	
				// Если нажата кнопка Делить
				else if (str=="/")
				{
					oper = 4;
				    p1 = Double.parseDouble(text.getText());
				    text.setText("");			
				}
				// Если нажата другая кнопка, не перечисленная
				// выше - значит цифры от 0 до 9
				else
				{
					// Прибавляем нажатую цифру справа от других цифр
					text.setText(""+text.getText()+str);
				}
	}

	// Конструктор класса окна
	public okno() {
		// Создаем переменную для достпуа к содержимому окна
		Container cont = getContentPane();
		// Создаем панель для окна
		JPanel pan = new JPanel();
		// Включаем возможность произвольного размещения
		// всех элементов формы (кнопок, текстовых полей и т.д.)
		pan.setLayout(null);
		// Создаем три шрифта для кнопок, надписей и текстовых полей
		Font btnFont = new Font("serif", 0, 20);
		Font labFont = new Font("arial", 1, 30);
		Font textFont = new Font("arial", 2, 30);
		// Создаем массив из 17 кнопок
		JButton[] btn = new JButton[17];
		// Устанавливаем для всех кнопок один шрифт и
		// и одинаковый размер, подключаем обработчик события
		// и сразу прикрепляем кнопки к панели
		for (int i = 0; i < 17; i++) {
			// Создаем кнопку
			btn[i] = new JButton();
			// Устанавливаем размер
			btn[i].setSize(100, 25);
			// Устанавливаем шрифт
			btn[i].setFont(btnFont);
			// Устанавливаем ее расположение
			btn[i].setLocation(30, 50 + i * 30);
			// Подключаем обработчик события
			btn[i].addActionListener(new ActionListener() {
				// Метод, который выполняется при нажатии кнопки
				public void actionPerformed(ActionEvent e) {
					// Вызов метода для обработки нажатия клавиш
					btnClick((JButton) e.getSource());
				}
			});
			// Прикрепляем кнопку к панели
			pan.add(btn[i]);
		}
		
		// Формируем надписи на кнопках
		for (int i = 0; i < 10; i++)
			btn[i].setText("" + i);
		btn[10].setText("+");
		btn[11].setText("-");
		btn[12].setText("/");
		btn[13].setText("*");
		btn[14].setText("=");
		btn[15].setText("C");
		btn[16].setText("Выход");

		// Создаем текстовую надпись
		JLabel lab = new JLabel("Результат: ");
		// Устанавливаем шрифт
		lab.setFont(labFont);
		// Устанавливаем размеры
		lab.setBounds(130, 0, 300, 50);
		// Прикрепляем надпись к панели
		pan.add(lab);
		// Создаем текстовое поле
		text = new JTextArea();
		// Устанавливаем шрифт
		text.setFont(textFont);
		// Устанавливаем размеры текстового поля
		text.setBounds(300, 10, 300, 35);
		// Устанавливаем цвет текста ТЕМНО-СИНИЙ
		text.setForeground(new Color(0, 0, 100));
		// Устанавливаем фон текстового поля - БЕЛЫЙ
		text.setBackground(Color.WHITE);
		// Прикрепляем текстовое поле к панели
		pan.add(text);
		// Прикрепляем панель к окну
		cont.add(pan);
		// Устанавливаем расположение и размеры окна
		setBounds(0, 0, 800, 600);
		// Устанавливаем заголовок окна
		setTitle("Калькулятор");
		// Запрет изменения размеров окна пользователем
		setResizable(false);
		// Устанавливаем окончание работы приложения
		// при закрытии окна
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Показываем (отображаем) окно
		setVisible(true);
	}
}
