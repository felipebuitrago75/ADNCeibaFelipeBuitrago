// spec.js
describe('Prueba pantalla principal', function() {
    it('should have a title', function() {
      browser.get('http://localhost:4200/');
  
      expect(browser.getTitle()).toEqual('Front');
    });
  });

  describe('Boton nueva persona', function() {
    it('crear persona', function() {
      browser.get('http://localhost:4200/');
  
      element(by.id('botonNuevo')).click();
  
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/crear-persona'); 
    });
  });

  describe('Boton nueva persona', function() {
    it('redirigir crear persona', function() {
      browser.get('http://localhost:4200/');
  
      element(by.id('botonNuevo')).click();
  
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/crear-persona'); 
    });
  });

  describe('Creacion persona', function() {
    it('creacion nueva persona', function() {
      browser.get('http://localhost:4200/crear-persona');
      element(by.id('campoIdentificacion')).sendKeys(1097400317);
      element(by.id('campoNombre')).sendKeys("Felipe");
      element(by.id('campoEdad')).sendKeys(26);
      element(by.id('botonCrear')).click();
      element(by.buttonText('OK')).click();
      
  
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/'); 
    });
  });