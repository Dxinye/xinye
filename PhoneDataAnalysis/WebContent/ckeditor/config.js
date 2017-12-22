/**
 * @license Copyright (c) 2003-2017, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here.
	// For complete reference see:
	// http://docs.ckeditor.com/#!/api/CKEDITOR.config
	
	config.language =  "zh-cn" ; 
    config.toolbar = 'Full';
    config.height = 300;
    config.image_previewText = " ";
	
	

	// The toolbar groups arrangement, optimized for two toolbar rows.
	config.toolbarGroups = [
		{ name: 'clipboard',   groups: [ 'clipboard', 'undo' ] },
		{ name: 'editing',     groups: [ 'find', 'selection', 'spellchecker' ] },
		{ name: 'links' },
		{ name: 'insert' },
		{ name: 'forms' },
		{ name: 'tools' },
		{ name: 'document',	   groups: [ 'mode', 'document', 'doctools' ] },
		{ name: 'others' },
		'/',
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
		{ name: 'paragraph',   groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ] },
		{ name: 'styles' },
		{ name: 'colors' },
		{ name: 'about' }
	];

	// Remove some buttons provided by the standard plugins, which are
	// not needed in the Standard(s) toolbar.
	config.removeButtons = 'Underline,Subscript,Superscript';

	// Set the most common block elements.
	config.format_tags = 'p;h1;h2;h3;pre';

	// Simplify the dialog windows.
	config.removeDialogTabs = 'image:advanced;link:advanced';
	
	
	//在ckeditor中集成ckfinder，注意选择路劲要正确
	
	// 上传文件时浏览服务文件夹                                                                                                       
	config.filebrowserBrowseUrl ='/PhoneDataAnalysis/ckfinder/ckfinder.html';                                                           
	// 上传图片时浏览服务文件夹                                                                                                        
	config.filebrowserImageBrowseUrl ='/PhoneDataAnalysis/ckfinder/ckfinder.html?Type=Images';                                          
	// 上传Flash时浏览服务文件夹                                                                                                     
	config.filebrowserFlashBrowseUrl ='/PhoneDataAnalysis/ckfinder/ckfinder.html?Type=Flash';                                           
	// 上传文件按钮(标签)                                                                                                         
	config.filebrowserUploadUrl ='/PhoneDataAnalysis/ckfinder/core/connector/aspx/connector.aspx?command=QuickUpload&type=Files';       
	// 上传图片按钮(标签)                                                                                                         
	config.filebrowserImageUploadUrl ='/PhoneDataAnalysis/ckfinder/core/connector/aspx/connector.aspx?command=QuickUpload&type=Images';  
	// 上传Flash按钮(标签)                                                                                                      
	config.filebrowserFlashUploadUrl ='/PhoneDataAnalysis/ckfinder/core/connector/aspx/connector.aspx?command=QuickUpload&type=Flash'; 
	
	 config.filebrowserWindowWidth = '1000';  
     config.filebrowserWindowHeight = '700';  
     config.language =  "zh-cn" ;
	
	
};
