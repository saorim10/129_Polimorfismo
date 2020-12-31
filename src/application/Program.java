package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		List<Employee> list = new ArrayList<>();

		System.out.print("Entre com o número de Funcionários: ");
		int nEmployees = sc.nextInt();
		System.out.println();
		
		
		for(int n = 1; n<=nEmployees; n++) {
			System.out.println("Dados do " + n + "º Funcionário");
			System.out.print("Terceirizado? (s/n) ");
			char resp = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Horas: ");
			int hours = sc.nextInt();
			System.out.print("Valor por Hora: ");
			double valuePerHour = sc.nextDouble();
			if(resp =='s') {
				System.out.print("Despesas adicionais: R$ ");
				double additionalCharge = sc.nextDouble();
				list.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
			} else {
				list.add(new Employee(name, hours, valuePerHour));
			}
			
		}
		
		System.out.println();
		System.out.println("PAGAMENTOS");
		for(Employee emp: list) {
			System.out.println(emp.getName() + " - R$ " + String.format("%.2f", emp.payment()));
		}
		
		sc.close();
	}

}
