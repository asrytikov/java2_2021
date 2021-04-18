

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class prog {

	// Объявляем переменную типа Robot
	public static Robot rob=null;
	
	public static void main(String[] args) {
		
		try
		{
			// Создаем новый объект класса Robot
			rob = new Robot();
		}
		catch (Exception e) {}
		
		// Создаем окно
		JFrame wnd = new JFrame();
		// Убираем рамку окна
		wnd.setUndecorated(true);
		// Размещать окно поверх других окон
		wnd.setAlwaysOnTop(true);
		// Помещаем окно в верхний левый угол экрана
		wnd.setLocation(0, 0);		
		// Располагать кнопки слева направо автоматически 
		wnd.setLayout(new FlowLayout());
		
		// Массив из пяти кнопок
		JButton[] btn = new JButton[5];		
		for (int i=0; i<5; i++)
		{
		   // Новая кнопка
		   btn[i] = new JButton();
		   // Имя кнопки
		   btn[i].setName("b"+i);
		   // Обработчик события при нажатии
		   btn[i].addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  // Определяем нажатую кнопку
				  JButton b = (JButton)e.getSource();
				  // Определяем имя кнопки
				  String name = b.getName();

				  if (name.equals("b0")) // Браузер
				  {
				        try
				        {
				    // Запуск Браузера
				ProcessBuilder proc = new ProcessBuilder(
	"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",
	"http:\\club.1c.ru");
						  proc.start();
					  }
					  catch (Exception ex) {}
				  }
				  else if (name.equals("b1")) // Мышь
				  {					    
				     // Перемещаем курсор по диагонали
				     for (int i=500; i>=0; i--)
				     {
					  // Установить положение курсора мыши X, Y
					  rob.mouseMove(i, i);			
					  // Задержка
					  rob.delay(5);
				     }		
			// Установить положение курсора мыши над кнопкой Блокнот
				     rob.mouseMove(50, 30);									
				    // Нажимаем левую клавишу мыши
				    rob.mousePress(MouseEvent.BUTTON1_MASK);
				    // Задержка
				    rob.delay(200);
				    // Отпускаем левую клавишу мыши
				    rob.mouseRelease(MouseEvent.BUTTON1_MASK);
				  }
				  else if (name.equals("b2")) // Калькулятор
				  {
				        try
				        {
				     // Запуск Калькулятора
		     ProcessBuilder proc = new ProcessBuilder("calc");
						 proc.start();
					  }
					  catch (Exception ex) {}
						
				        // Ждём пять секунд
				        rob.delay(5000);

		     // Закрываем калькулятор комбинацией клавиш Alt+F4
				        rob.keyPress(KeyEvent.VK_ALT);
				        rob.delay(100);
				        rob.keyPress(KeyEvent.VK_F4);
				        rob.delay(100);
				        rob.keyRelease(KeyEvent.VK_F4);
				        rob.delay(100);
				        rob.keyRelease(KeyEvent.VK_ALT);
				        rob.delay(100);				        

				  }
				  else if (name.equals("b3")) // Мигание
				  {
					  for (int i=0; i<10; i++)
					  {
					     // Нажимаем клавишу CapsLock
					     rob.keyPress(KeyEvent.VK_CAPS_LOCK);
					     // Задержка половина секунды
					     rob.delay(500);
					     // Отпускаем клавишу CapsLock
					     rob.keyRelease(KeyEvent.VK_CAPS_LOCK);						    
						    
					     // Нажимаем клавишу NumLock
					     rob.keyPress(KeyEvent.VK_NUM_LOCK);
					     // Задержка половина секунды
					     rob.delay(500);						    
					     // Отпускаем клавишу NumLock
					     rob.keyRelease(KeyEvent.VK_NUM_LOCK);
						    						    
					     // Нажимаем клавишу ScrollLock
					     rob.keyPress(KeyEvent.VK_SCROLL_LOCK);
					     // Задержка половина секунды
					     rob.delay(500);
					     // Отпускаем клавишу ScrollLock
					     rob.keyRelease(KeyEvent.VK_SCROLL_LOCK);
					  }
				  }				  
				  else if (name.equals("b4")) // Выход
				  {
					  // Завершение работы приложения
					  System.exit(0);
				  }
			  }
		   });
		   // Добавляем кнопку
		   wnd.add(btn[i]);
		}
		
		// Устанавливаем текст на кнопках
		btn[0].setText("Браузер");
		btn[1].setText("Мышь");
		btn[2].setText("Калькулятор");
		btn[3].setText("Мигание");
		btn[4].setText("Выход");
		
		// Установить размеры окна автоматически
		wnd.pack();
		
		// Завершать работу приложения при закрытии окна
		wnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Выводим окно
		wnd.setVisible(true);
		
	}
}

